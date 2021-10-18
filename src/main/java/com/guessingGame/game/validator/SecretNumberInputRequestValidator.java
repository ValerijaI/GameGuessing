package com.guessingGame.game.validator;

import com.guessingGame.game.request.SecretNumberInputRequest;
import com.guessingGame.game.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecretNumberInputRequestValidator {

    public Optional<CoreError> validate(SecretNumberInputRequest secretNumberInputRequest) {
        return validateIfContainsOnlyFourDigits(secretNumberInputRequest);
    }

    private Optional<CoreError> validateIfContainsOnlyFourDigits(SecretNumberInputRequest secretNumberInputRequest) {
        return (!secretNumberInputRequest.getGuess().matches("\\d{4}"))
                ? Optional.of(new CoreError("Number", "Secret number contains only four digits"))
                : Optional.empty();
    }
}
