package com.guessingGame.game.service;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Guess {
    private String correctSecretNumber;
    private String guess;
    private Map<String, String> triesMap;
}
