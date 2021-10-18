package com.guessingGame.game.service;

import com.guessingGame.game.creation.CreateSecretNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenerateSecretNumberService {

    @Autowired
    private CreateSecretNumber createSecretNumber;

    public List<Integer>execute() {
        return createSecretNumber.createSecretNumber();
    }
}
