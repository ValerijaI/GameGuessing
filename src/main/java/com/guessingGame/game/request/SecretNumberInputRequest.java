package com.guessingGame.game.request;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class SecretNumberInputRequest {

    private String correctSecretNumber;
    private String guess;
    private int tries;
    private Map<String, String> triesMap = new HashMap<>();
}
