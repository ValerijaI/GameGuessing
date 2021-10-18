package com.guessingGame.game.service;

import com.guessingGame.game.entity.MoveEntity;
import com.guessingGame.game.request.InputNameRequest;
import org.springframework.stereotype.Component;

@Component
public class MoveConverter {

    public MoveEntity fromInputNameRequestToMoveEntity(InputNameRequest inputNameRequest) {
        MoveEntity moveEntity = new MoveEntity();
        //moveEntity.setId(inputNameRequest.getId());
        moveEntity.setName(inputNameRequest.getName());
        moveEntity.setSecretNumber("");
        moveEntity.setGuess("");
        moveEntity.setResult("");
        moveEntity.setTries(0);
        return moveEntity;
    }

    public MoveEntity fromGuessToMoveEntity(Guess guess, String result) {
        MoveEntity moveEntity = new MoveEntity();
        //moveEntity.setId(inputNameRequest.getId());
        moveEntity.setName("");
        moveEntity.setSecretNumber(guess.getCorrectSecretNumber());
        moveEntity.setGuess(guess.getGuess());
        moveEntity.setResult(result);
        moveEntity.setTries(guess.getTriesMap().size());
        return moveEntity;
    }

}
