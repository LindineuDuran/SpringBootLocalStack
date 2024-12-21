package br.com.lduran.config;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

import java.net.URI;

@Setter
@Configuration
@EnableConfigurationProperties
public class ParameterStoreConfig {

	@Value("${helloWorld:Default Hello World}")
	private String helloWorld;

	public String getHelloWorld() {
		String parameterName = "/config/spring-boot-localstack_localstack/helloWorld";

		// Configurar credenciais fictícias para LocalStack
		AwsBasicCredentials awsCreds = AwsBasicCredentials.create("test", "test");

		// Configurar o cliente SSM para usar o endpoint do LocalStack
		SsmClient ssmClient = SsmClient.builder()
				.credentialsProvider(StaticCredentialsProvider.create(awsCreds))
				.region(Region.SA_EAST_1)
				.endpointOverride(URI.create("http://localhost:4566")) // Endpoint do LocalStack
				.build();

		try {
			// Requisição ao Parameter Store
			GetParameterRequest parameterRequest = GetParameterRequest.builder()
					.name(parameterName)
					.build();

			GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
			return parameterResponse.parameter().value();

		} catch (SsmException e) {
			System.err.println("Erro ao obter parâmetro do Parameter Store: " + e.getMessage());
			return helloWorld; // Retorna o valor padrão caso ocorra um erro
		}
	}
}
