package br.com.lduran.controller;

import br.com.lduran.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
public class S3Controller
{
	private final S3Service s3Service;

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam String fileName, @RequestParam String content)
	{
		s3Service.uploadFile(fileName, content);
		return ResponseEntity.ok("File uploaded successfully!");
	}

	@GetMapping("/files")
	public ResponseEntity<List<String>> listFiles()
	{
		return ResponseEntity.ok(s3Service.listFiles());
	}

	@GetMapping("/file")
	public ResponseEntity<String> getFileContent(@RequestParam String fileName)
	{
		return ResponseEntity.ok(s3Service.getFileContent(fileName));
	}

	/**
	 * Endpoint para apagar um arquivo no bucket S3.
	 *
	 * @param fileName Nome do arquivo a ser apagado.
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteFile(@RequestParam String fileName) {
		try {
			s3Service.deleteFile(fileName);
			return ResponseEntity.ok("Arquivo removido com sucesso: " + fileName);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao remover o arquivo: " + fileName);
		}
	}
}
