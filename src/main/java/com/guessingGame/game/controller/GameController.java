package com.guessingGame.game.controller;

import com.guessingGame.game.request.InputNameRequest;
import com.guessingGame.game.request.SecretNumberInputRequest;
import com.guessingGame.game.response.GameMoveResponse;
import com.guessingGame.game.response.InputNameResponse;
import com.guessingGame.game.service.GameMoveService;
import com.guessingGame.game.service.GenerateSecretNumberService;
import com.guessingGame.game.service.InputNameService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/playGame")
@Log
public class GameController {

    private static String playerName;

    private final InputNameService inputNameService;
    private final GenerateSecretNumberService generateSecretNumberService;
    private final GameMoveService gameMoveService;

    @PostMapping("/enterName")
    public InputNameResponse enterName(@RequestBody InputNameRequest inputNameRequest) {
        log.info("Name " + inputNameRequest.getName());
        playerName = inputNameRequest.getName();
        return inputNameService.execute(inputNameRequest);
    }

    @PostMapping("/guess")
    public GameMoveResponse guess(@RequestBody SecretNumberInputRequest secretNumberInputRequest) {
        log.info("Guess " + secretNumberInputRequest);
        return gameMoveService.execute(secretNumberInputRequest);
    }
}
