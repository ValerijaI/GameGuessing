package com.guessingGame.game.response;

public class InputNameResponse extends CoreResponse{

    private String name;

    public InputNameResponse(String name) {
        this.name = name;
    }

    public InputNameResponse(CoreError error) {
        super(error);
    }

    public String getName() {
        return name;
    }
}
