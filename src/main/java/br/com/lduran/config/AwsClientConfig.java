package br.com.lduran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

import java.net.URI;

@Configuration
public class AwsClientConfig
{
	@Bean
	public SnsClient snsClient()
	{
		return SnsClient.builder()
						.region(Region.of("sa-east-1")) // Certifique-se de usar a mesma região configurada
						.endpointOverride(URI.create("http://localhost:4566")) // Aponta para o LocalStack
						.credentialsProvider(StaticCredentialsProvider.create(
								AwsBasicCredentials.create("test", "test") // Credenciais para o LocalStack
						))
						.build();
	}
}
