package com.guessingGame.game.service;

import com.guessingGame.game.entity.MoveEntity;
import com.guessingGame.game.repository.MoveRepository;
import com.guessingGame.game.request.InputNameRequest;
import com.guessingGame.game.response.CoreError;
import com.guessingGame.game.response.InputNameResponse;
import com.guessingGame.game.validator.InputNameRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InputNameService {

    @Autowired
    private InputNameRequestValidator inputNameRequestValidator;
    @Autowired
    private MoveRepository moveRepository;
    @Autowired
    private MoveConverter moveConverter;

    public InputNameResponse execute(InputNameRequest inputNameRequest) {
        Optional<CoreError> validationError = inputNameRequestValidator.validate(inputNameRequest);

        if (validationError.isPresent()) {
            return new InputNameResponse(validationError.get());
        }
        MoveEntity moveEntity = new MoveEntity();
        moveRepository.save(moveConverter.fromInputNameRequestToMoveEntity(inputNameRequest));
        return new InputNameResponse(inputNameRequest.getName());
    }
}
