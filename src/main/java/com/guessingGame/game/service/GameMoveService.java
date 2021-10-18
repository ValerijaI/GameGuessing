package com.guessingGame.game.service;

import com.guessingGame.game.repository.MoveRepository;
import com.guessingGame.game.request.SecretNumberInputRequest;
import com.guessingGame.game.response.CoreError;
import com.guessingGame.game.response.GameMoveResponse;
import com.guessingGame.game.validator.SecretNumberInputRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GameMoveService {

    @Autowired
    private SecretNumberInputRequestValidator secretNumberInputRequestValidator;
    @Autowired
    private MoveRepository moveRepository;
    @Autowired
    private MoveConverter moveConverter;

    public GameMoveResponse execute(SecretNumberInputRequest secretNumberInputRequest) {
        Optional<CoreError> validationError = secretNumberInputRequestValidator.validate(secretNumberInputRequest);

        if (validationError.isPresent()) {
            return new GameMoveResponse(validationError.get());
        }

        String currentGuess = secretNumberInputRequest.getGuess();

        String result = getResult(secretNumberInputRequest.getCorrectSecretNumber(), currentGuess);

        secretNumberInputRequest.getTriesMap().put(secretNumberInputRequest.getGuess(), result);

        Guess guess = new Guess(secretNumberInputRequest.getCorrectSecretNumber(), secretNumberInputRequest.getGuess(), secretNumberInputRequest.getTriesMap());
        moveRepository.save(moveConverter.fromGuessToMoveEntity(guess, result));

        if (isCorrectNumber(secretNumberInputRequest.getCorrectSecretNumber(), currentGuess)) {
            return new GameMoveResponse( result, guess.getTriesMap(), true, true);
        }

        return new GameMoveResponse(result, guess.getTriesMap(), false, guess.getTriesMap().size() == 8);
    }

    private String getResult(String secretNumber, String guess) {
        int p = getNumberOfMatchingDigitsOnTheRightPlaces(secretNumber, guess);
        int m = getNumberOfMatchingDigitsNotOnTheRightPlaces(secretNumber, guess, p);
        return "M:" + m + "; P:" + p;
    }

    private boolean isCorrectNumber(String secretNumber, String guess) {
        return secretNumber.equals(guess);
    }

    private int getNumberOfMatchingDigitsNotOnTheRightPlaces(String secretNumber, String guess, int digitsOnRightPlaces) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (secretNumber.indexOf(guess.charAt(i)) > -1) {
                count++;
            }
        }
        return Math.max(count - digitsOnRightPlaces, 0);
    }

    private int getNumberOfMatchingDigitsOnTheRightPlaces(String secretNumber, String guess) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (secretNumber.charAt(i) == guess.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
