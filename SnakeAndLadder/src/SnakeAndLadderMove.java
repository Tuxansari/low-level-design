package com.lld;

public class SnakeAndLadderMove extends Move {
    private int step;

    public SnakeAndLadderMove(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
