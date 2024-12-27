package br.com.lduran.entity;

import lombok.Setter;
import java.time.Instant;
import java.util.UUID;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


@Setter
@DynamoDbBean
public class Book
{
	private String id;
	private String title;
	private String author;

	public Book()
	{
		this.id = Instant.now().toString() + "-" + UUID.randomUUID().toString();
	}

	@DynamoDbPartitionKey
	@DynamoDbAttribute("id")
	public String getId()
	{
		return id;
	}

	@DynamoDbAttribute("title")
	public String getTitle()
	{
		return this.title;
	}

	@DynamoDbAttribute("author")
	public String getAuthor() { return this.author; }
}