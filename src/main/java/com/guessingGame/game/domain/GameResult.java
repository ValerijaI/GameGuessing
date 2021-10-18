package com.guessingGame.game.domain;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class GameResult {

    private Long id;
    private String name;
    private Integer playedGames;
    private Integer gamesIsWin;
    private Integer tries;
    private Double percent;

}