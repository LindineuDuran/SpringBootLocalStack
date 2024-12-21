package br.com.lduran.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

import java.net.URI;

@Configuration
@EnableConfigurationProperties
public class SecretsManagerConfig
{
	@Value("${aws.secretsmanager.endpoint:http://localhost:4566}")
	private String secretsManagerEndpoint;

	@Value("${aws.secretsmanager.region:sa-east-1}")
	private String region;

	@Value("${aws.secretsmanager.secret-name:/secret/spring-boot-localstack_localstack}")
	private String secretName;

	private SecretsManagerClient createSecretsManagerClient()
	{
		return SecretsManagerClient.builder().region(Region.of(region)).endpointOverride(URI.create(secretsManagerEndpoint)).build();
	}

	public JsonNode getSecretJson()
	{
		SecretsManagerClient secretsManagerClient = createSecretsManagerClient();

		try
		{
			GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder().secretId(secretName).build();

			GetSecretValueResponse getSecretValueResponse = secretsManagerClient.getSecretValue(getSecretValueRequest);

			String secretString = getSecretValueResponse.secretString();
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readTree(secretString);
		}
		catch (SecretsManagerException e)
		{
			System.err.println(e.awsErrorDetails().errorMessage());
			return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public String getValor1()
	{
		JsonNode secretJson = getSecretJson();
		return secretJson != null && secretJson.has("valor1") ? secretJson.get("valor1").asText() : "DefaultValor1";
	}

	public String getValor2()
	{
		JsonNode secretJson = getSecretJson();
		return secretJson != null && secretJson.has("valor2") ? secretJson.get("valor2").asText() : "DefaultValor2";
	}

	public String getValor3()
	{
		JsonNode secretJson = getSecretJson();
		return secretJson != null && secretJson.has("valor3") ? secretJson.get("valor3").asText() : "DefaultValor3";
	}
}
