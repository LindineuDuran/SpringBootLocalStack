package br.com.lduran.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3Service {
	private final S3Client s3Client;

	@Value("${s3.bucket.name}")
	private String bucketName;

	/**
	 * Faz upload de um arquivo para o bucket S3.
	 */
	public void uploadFile(String fileName, String content) {
		s3Client.putObject(PutObjectRequest.builder()
						.bucket(bucketName)
						.key(fileName)
						.build(),
				RequestBody.fromString(content));
	}

	/**
	 * Lista os arquivos no bucket S3.
	 */
	public List<String> listFiles() {
		ListObjectsV2Response response = s3Client.listObjectsV2(
				ListObjectsV2Request.builder()
						.bucket(bucketName)
						.build()
		);

		return response.contents()
				.stream()
				.map(S3Object::key)
				.collect(Collectors.toList());
	}

	/**
	 * Obtém o conteúdo de um arquivo no bucket S3.
	 */
	public String getFileContent(String fileName)
	{
		try (ResponseInputStream<GetObjectResponse> response = s3Client.getObject(
				GetObjectRequest.builder()
						.bucket(bucketName)
						.key(fileName)
						.build())) {

			// Lê o conteúdo do arquivo
			BufferedReader reader = new BufferedReader(new InputStreamReader(response));
			return reader.lines().collect(Collectors.joining("\n"));
		} catch (Exception e) {
			throw new RuntimeException("Erro ao ler o conteúdo do arquivo: " + fileName, e);
		}
	}

	/**
	 * Apaga um arquivo do bucket S3.
	 */
	public void deleteFile(String fileName)
	{
		try {
			s3Client.deleteObject(DeleteObjectRequest.builder()
					.bucket(bucketName)
					.key(fileName)
					.build());
			log.info("Arquivo [{}] removido com sucesso do bucket [{}].", fileName, bucketName);
		} catch (Exception e) {
			log.error("Erro ao remover arquivo [{}] do bucket [{}].", fileName, bucketName, e);
			throw new RuntimeException("Erro ao remover o arquivo: " + fileName, e);
		}
	}
}
