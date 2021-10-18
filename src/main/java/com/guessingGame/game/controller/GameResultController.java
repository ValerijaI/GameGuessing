package com.guessingGame.game.controller;

import com.guessingGame.game.domain.GameResult;
import com.guessingGame.game.service.LeaderBoardService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/gameResult")
@Log
public class GameResultController {

    private final LeaderBoardService leaderBoardService;

    @PostMapping("/save")
    public GameResult saveGameResult(@RequestBody GameResult gameResult) {
        log.info("Handling save game result " + gameResult);
        return leaderBoardService.saveGameResult(gameResult);
    }

    @GetMapping("/findAll")
    public List<GameResult> findAllGameResults() {
        log.info("Handling find all game results request");
        return leaderBoardService.findAll();
    }

    @GetMapping("/findAllWithMoreThanXGames")
    public List<GameResult> findAllGameResultsWithMoreThanXGames(@RequestParam Integer count) {
        log.info("Handling find all game results with more than x games");
        return leaderBoardService.findAllWithMoreThanXGames(count);
    }
}
