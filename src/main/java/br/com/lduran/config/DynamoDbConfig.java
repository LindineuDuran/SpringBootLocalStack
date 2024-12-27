package br.com.lduran.config;

import br.com.lduran.entity.Book;
import br.com.lduran.entity.PlayerHistoryEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDbConfig
{

	@Bean
	public DynamoDbClient dynamoDbClient()
	{
		return DynamoDbClient.builder()
							 .region(Region.SA_EAST_1)
							 .endpointOverride(URI.create("http://localhost:4566")) // LocalStack endpoint
							 .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test")))
							 .build();
	}

	@Bean
	public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient)
	{
		return DynamoDbEnhancedClient.builder().dynamoDbClient(dynamoDbClient).build();
	}

	@Bean
	public DynamoDbTable<PlayerHistoryEntity> playerHistoryTable(DynamoDbEnhancedClient dynamoDbEnhancedClient)
	{
		return dynamoDbEnhancedClient.table("PlayerHistory", TableSchema.fromBean(PlayerHistoryEntity.class));
	}

	@Bean
	public DynamoDbTable<Book> bookDynamoDbTable(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
		return dynamoDbEnhancedClient.table("Books", TableSchema.fromBean(Book.class));
	}
}