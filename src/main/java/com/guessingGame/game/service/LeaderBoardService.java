package com.guessingGame.game.service;

import com.guessingGame.game.domain.GameResult;

import java.util.List;

public interface LeaderBoardService {

    GameResult saveGameResult(GameResult gameResult);

    List<GameResult> findAll();

    List<GameResult> findAllWithMoreThanXGames(Integer count);

}