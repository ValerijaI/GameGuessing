package com.guessingGame.game.validator;

import com.guessingGame.game.request.InputNameRequest;
import com.guessingGame.game.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InputNameRequestValidator {

    public Optional<CoreError> validate(InputNameRequest inputNameRequest) {
        return validateName(inputNameRequest);
    }

    private Optional<CoreError> validateName(InputNameRequest inputNameRequest) {
        return (inputNameRequest.getName() == null || inputNameRequest.getName().isEmpty())
                ? Optional.of(new CoreError("Name", "Must be not empty"))
                : Optional.empty();
    }
}