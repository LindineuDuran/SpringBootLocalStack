package br.com.lduran.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto
{
	private String playerId;
	private Double score;
}
