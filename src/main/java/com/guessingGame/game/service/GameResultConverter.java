package com.guessingGame.game.service;

import com.guessingGame.game.domain.GameResult;
import com.guessingGame.game.entity.GameResultEntity;
import org.springframework.stereotype.Component;

@Component
public class GameResultConverter {

    public GameResultEntity fromGameResultToGameResultEntity(GameResult gameResult) {
        GameResultEntity gameResultEntity = new GameResultEntity();
        gameResultEntity.setId(gameResult.getId());
        gameResultEntity.setName(gameResult.getName());
        gameResultEntity.setPlayedGames(gameResult.getPlayedGames());
        gameResultEntity.setGamesIsWin(gameResult.getGamesIsWin());
        gameResultEntity.setTries(gameResult.getTries());
        gameResultEntity.setPercent(gameResult.getPercent());
        return gameResultEntity;
    }

    public GameResult fromGameResultEntityToGameResult(GameResultEntity gameResultEntity) {
        return GameResult.builder()
                .id(gameResultEntity.getId())
                .name(gameResultEntity.getName())
                .playedGames(gameResultEntity.getPlayedGames())
                .gamesIsWin(gameResultEntity.getGamesIsWin())
                .tries(gameResultEntity.getTries())
                .percent(gameResultEntity.getPercent())
                .build();
    }
}
