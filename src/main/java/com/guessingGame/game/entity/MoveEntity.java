package com.guessingGame.game.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "gameData")
@Data
@NoArgsConstructor
public class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String secretNumber;

    @Column
    private String guess;

    @Column
    private String result;

    @Column
    private Integer tries;
}
