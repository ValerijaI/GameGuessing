package com.guessingGame.game.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "gameResultBoard")
@Data
@NoArgsConstructor
public class GameResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer playedGames;

    @Column
    private Integer gamesIsWin;

    @Column
    private Integer tries;

    @Column
    private Double percent;
}
