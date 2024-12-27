package br.com.lduran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

import java.net.URI;

@Configuration
public class S3Config
{
	@Bean
	public S3Client s3Client()
	{
		return S3Client.builder().region(Region.SA_EAST_1) // Região configurada
				.endpointOverride(URI.create("http://localhost:4566")) // Aponta para o LocalStack
				.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test") // Credenciais para o LocalStack
				)).serviceConfiguration(builder -> builder.pathStyleAccessEnabled(true)) // Ativar Path-Style Access
				.build();
	}

	@Bean
	public S3Presigner s3Presigner()
	{
		return S3Presigner.builder().region(Region.SA_EAST_1).credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test")))
				.endpointOverride(URI.create("http://localhost:4566")) // Aponta para o LocalStack
				.build();
	}
}