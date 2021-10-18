package com.guessingGame.game.response;

import java.util.Map;

public class GameMoveResponse extends CoreResponse{

    private String result;
    private Map<String, String> triesMap;
    private boolean isWin;
    private boolean gameOver;

    public GameMoveResponse(String result, Map<String, String> triesMap, boolean isWin, boolean gameOver) {
        this.result = result;
        this.triesMap = triesMap;
        this.isWin = isWin;
        this.gameOver = gameOver;
    }

    public GameMoveResponse(CoreError error) {
        super(error);
    }

    public String getResult() {
        return result;
    }

    public boolean isWin() {
        return isWin;
    }

    public Map<String, String> getTriesMap() {
        return triesMap;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
