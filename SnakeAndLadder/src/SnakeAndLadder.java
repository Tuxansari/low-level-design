package com.lld;

import java.util.*;

public class SnakeAndLadder implements BoardGame {

    private HashMap<Integer, Integer> snakes, ladders;
    private List<PlayerMove> moveList;
    private HashMap<Integer, Integer> playerPosition;
    private Random random = new Random();
    private int winnerPlayerId;
    private int winningSpot;

    /**
     * Get current board state
     * If we add few more animal
     * Add dice class of given faces
     * @param playerList
     * @param lastSpot
     */
    public SnakeAndLadder(List<Player> playerList, int lastSpot) {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        moveList = new ArrayList<>();
        playerPosition = new HashMap<>();
        winningSpot = lastSpot;
        winnerPlayerId = -1;

        List<Integer> spots = new ArrayList<>();
        int totalLadder, totalSnake;
        totalSnake = totalLadder = lastSpot / 10;

        for (int i=1;i<lastSpot;i++) {
            spots.add(i);
        }

        // fill snakes
        for (int i = 0; i< totalSnake; i++) {
            int num1 = getRandomSpot(spots);
            int num2 = getRandomSpot(spots);
            if (num1 > num2)
                snakes.put(num1,num2);
            else
                snakes.put(num2, num1);
        }

        // fill ladder
        for (int i = 0; i< totalLadder; i++) {
            int num1 = getRandomSpot(spots);
            int num2 = getRandomSpot(spots);
            if (num1 < num2)
                ladders.put(num1, num2);
            else
                ladders.put(num2, num1);
        }

        // fill player position
        for (Player player : playerList) {
            playerPosition.put(player.getId(), 1);
        }
    }

    @Override
    public void resetBoard() {

    }

    @Override
    public int getWinner() {
        return winnerPlayerId;
    }

    @Override
    public int turn(int playerId, Move move) {
        if (this.getWinner() != -1)
            throw new IllegalStateException("Game is completed");
        SnakeAndLadderMove snakeAndLadderMove = (SnakeAndLadderMove) move;

        int playerCurrentPos = playerPosition.get(playerId);
        int playerExpectedPos = playerCurrentPos + snakeAndLadderMove.getStep();
        if (playerExpectedPos == winningSpot) {
            winnerPlayerId = playerId;
        } else if (snakes.containsKey(playerExpectedPos)) {
            playerExpectedPos = snakes.get(playerExpectedPos);
        } else if (ladders.containsKey(playerExpectedPos)) {
            playerExpectedPos = ladders.get(playerExpectedPos);
        }
        if (playerExpectedPos < winningSpot) {
            playerPosition.put(playerId, playerExpectedPos);
            PlayerMove playerMove = new PlayerMove(playerId, playerCurrentPos, playerExpectedPos);
            moveList.add(playerMove);
        }
        return winnerPlayerId;
    }

    @Override
    public void undoMove(int count) {
        int idx = Math.min(moveList.size(), count);
        while (idx-- > 0) {
            PlayerMove playerMove = moveList.get(idx);
            playerPosition.put(playerMove.getPlayedId(), playerMove.getInitialPos());
        }
    }

    private int getRandomSpot(List<Integer> spots) {
        int randomNum = random.nextInt(spots.size());
        int number = spots.get(randomNum);
        spots.remove(randomNum);
        return number;
    }

}
