package com.guessingGame.game.creation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CreateSecretNumberImpl implements CreateSecretNumber{

    @Override
    public List<Integer> createSecretNumber() {
        List<Integer> secretNumber = new ArrayList<>();
        int i = 0;
        while (i < 4) {
            int number = getNewDigit();
            if (isDifferentNumber(secretNumber, number)) {
                secretNumber.add(number);
                i++;
            }
        }
        return secretNumber;
    }

    private int getNewDigit() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private boolean isDifferentNumber(List<Integer> secretNumber, int number) {
        return secretNumber.indexOf(number) == -1;
    }
}
