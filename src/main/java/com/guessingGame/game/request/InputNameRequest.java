package com.guessingGame.game.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputNameRequest {

    private String name;
}
