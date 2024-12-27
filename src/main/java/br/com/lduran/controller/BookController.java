package br.com.lduran.controller;

import br.com.lduran.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController
{
	private final DynamoDbTable<Book> bookDynamoDbTable;

	public BookController(DynamoDbTable<Book> bookDynamoDbTable)
	{
		this.bookDynamoDbTable = bookDynamoDbTable;
	}

	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book)
	{
		bookDynamoDbTable.putItem(book);

		// Busca um único livro pelo `id`
		var key = Key.builder().partitionValue(book.getId()).build();
		var savedBook = bookDynamoDbTable.getItem(r -> r.key(key));

		return savedBook == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(savedBook);
	}

	@PostMapping("/list")
	public ResponseEntity<Book> createBookList(@RequestBody List<Book> books)
	{
		books.forEach(bookDynamoDbTable::putItem);

		return ResponseEntity.status(204).build();
	}

	@GetMapping
	public ResponseEntity<List<Book>> listBooks()
	{
		// Lista todos os itens da tabela
		var results = bookDynamoDbTable.scan().items().stream().collect(Collectors.toList());

		return ResponseEntity.ok(results);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") String id)
	{
		// Busca um único livro pelo `id`
		var key = Key.builder().partitionValue(id).build();
		var book = bookDynamoDbTable.getItem(r -> r.key(key));

		return book == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(book);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> update(@PathVariable("id") String playerId, @RequestBody Book newBook)
	{
		var key = Key.builder().partitionValue(playerId).build();
		var book = bookDynamoDbTable.getItem(r -> r.key(key));

		if (book == null)
		{
			return ResponseEntity.notFound().build();
		}

		book.setTitle(newBook.getTitle());
		book.setAuthor(newBook.getAuthor());

		bookDynamoDbTable.putItem(book);

		var savedBook = bookDynamoDbTable.getItem(r -> r.key(key));

		return savedBook == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(savedBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String playerId)
	{
		var key = Key.builder().partitionValue(playerId).build();
		var book = bookDynamoDbTable.getItem(r -> r.key(key));

		if (book == null)
		{
			return ResponseEntity.notFound().build();
		}

		bookDynamoDbTable.deleteItem(r -> r.key(key));
		return ResponseEntity.noContent().build();
	}
}