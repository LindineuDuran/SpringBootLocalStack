package br.com.lduran.entity;

import br.com.lduran.entity.dto.PlayerDto;
import br.com.lduran.entity.dto.ScoreDto;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.Instant;
import java.util.UUID;

@Setter
@DynamoDbBean
public class PlayerHistoryEntity
{
	private String playerId;
	private String gameId;
	private Double score;
	private Instant createdAt;

	public static PlayerHistoryEntity fromScore(String playerId, ScoreDto scoreDto)
	{
		var playerHistory = new PlayerHistoryEntity();

		playerHistory.setPlayerId(playerId);
		playerHistory.setGameId(Instant.now().toString() + "-" + UUID.randomUUID().toString());
		playerHistory.setScore(scoreDto.getScore());
		playerHistory.setCreatedAt(Instant.now());

		return playerHistory;
	}

	@DynamoDbPartitionKey
	@DynamoDbAttribute("player_id")
	public String getPlayerId()
	{
		return playerId;
	}

	@DynamoDbSortKey
	@DynamoDbAttribute("game_id")
	public String getGameId()
	{
		return gameId;
	}

	@DynamoDbAttribute("score")
	public Double getScore()
	{
		return score;
	}

	@DynamoDbAttribute("created_at")
	public Instant getCreatedAt()
	{
		return createdAt;
	}
}