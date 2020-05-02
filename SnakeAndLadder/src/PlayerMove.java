package com.lld;

public class PlayerMove extends Move {
    private int playedId;
    private int initialPos;
    private int finalPos;

    public PlayerMove(int playerId, int playerCurrentPos, int playerExpectedPos) {
        this.playedId = playerId;
        this.initialPos = playerCurrentPos;
        this.finalPos = playerExpectedPos;
    }

    public int getPlayedId() {
        return playedId;
    }

    public void setPlayedId(int playedId) {
        this.playedId = playedId;
    }

    public int getInitialPos() {
        return initialPos;
    }

    public void setInitialPos(int initialPos) {
        this.initialPos = initialPos;
    }

    public int getFinalPos() {
        return finalPos;
    }

    public void setFinalPos(int finalPos) {
        this.finalPos = finalPos;
    }
}
