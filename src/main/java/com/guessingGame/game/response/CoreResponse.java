package com.guessingGame.game.response;

abstract class CoreResponse {

    private CoreError error;

    public CoreResponse() { }

    public CoreResponse(CoreError error) {
        this.error = error;
    }

    public CoreError getError() {
        return error;
    }

    public boolean hasError() {
        return error != null;
    }
}
