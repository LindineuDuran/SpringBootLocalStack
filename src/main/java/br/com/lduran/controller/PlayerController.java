package br.com.lduran.controller;

import br.com.lduran.entity.PlayerHistoryEntity;
import br.com.lduran.entity.dto.ScoreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController
{
	private final DynamoDbTable<PlayerHistoryEntity> playerHistoryTable;

	public PlayerController(DynamoDbTable<PlayerHistoryEntity> playerHistoryTable)
	{
		this.playerHistoryTable = playerHistoryTable;
	}

	@PostMapping("/{playerId}/games")
	public void create(@PathVariable("playerId") String playerId, @RequestBody ScoreDto scoreDto)
	{
		var playerHistory = PlayerHistoryEntity.fromScore(playerId, scoreDto);
		playerHistoryTable.putItem(playerHistory);
	}

	@GetMapping("/{playerId}/games")
	public ResponseEntity<List<PlayerHistoryEntity>> listGames(@PathVariable("playerId") String playerId)
	{
		var conditional = QueryConditional.keyEqualTo(Key.builder().partitionValue(playerId).build());
		var results = playerHistoryTable.query(r -> r.queryConditional(conditional)).items().stream().collect(Collectors.toList());

		return ResponseEntity.ok(results);
	}

	@GetMapping("/{playerId}/games/{gameId}")
	public ResponseEntity<PlayerHistoryEntity> getById(@PathVariable("playerId") String playerId, @PathVariable("gameId") String gameId)
	{
		var key = Key.builder().partitionValue(playerId).sortValue(gameId).build();
		var playerHistory = playerHistoryTable.getItem(r -> r.key(key));

		return playerHistory == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(playerHistory);
	}

	@DeleteMapping("/{playerId}/games/{gameId}")
	public ResponseEntity<Void> delete(@PathVariable("playerId") String playerId, @PathVariable("gameId") String gameId)
	{
		var key = Key.builder().partitionValue(playerId).sortValue(gameId).build();
		var playerHistory = playerHistoryTable.getItem(r -> r.key(key));

		if (playerHistory == null)
		{
			return ResponseEntity.notFound().build();
		}

		playerHistoryTable.deleteItem(r -> r.key(key));
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{playerId}/games/{gameId}")
	public ResponseEntity<Void> update(@PathVariable("playerId") String playerId, @PathVariable("gameId") String gameId, @RequestBody ScoreDto scoreDto)
	{
		var key = Key.builder().partitionValue(playerId).sortValue(gameId).build();
		var playerHistory = playerHistoryTable.getItem(r -> r.key(key));

		if (playerHistory == null)
		{
			return ResponseEntity.notFound().build();
		}

		playerHistory.setScore(scoreDto.getScore());
		playerHistoryTable.putItem(playerHistory);

		return ResponseEntity.noContent().build();
	}
}