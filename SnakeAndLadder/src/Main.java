package com.lld;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player(1));
        playerList.add(new Player(2));
        playerList.add(new Player(3));

        BoardGame game1 = new SnakeAndLadder(playerList,100);
//        game1.start();
        game1.turn(1,new SnakeAndLadderMove(2));
        game1.turn(2,new SnakeAndLadderMove(5));
        game1.turn(3,new SnakeAndLadderMove(9));
        System.out.println("Game 1 Status : " + (game1.getWinner() != -1 ? "Game is In-Progress" : game1.getWinner()));



        BoardGame game2 = new SnakeAndLadder(playerList,100);
        game2.turn(1,new SnakeAndLadderMove(3));
        game2.turn(2,new SnakeAndLadderMove(5));
        game2.turn(3,new SnakeAndLadderMove(99));
        System.out.println("Game 2 Status : " + (game2.getWinner() == -1 ? "Game is In-Progress" : game2.getWinner()));



        BoardGame game3 = new SnakeAndLadder(playerList,100);
        game3.turn(1,new SnakeAndLadderMove(99));
        game3.turn(2,new SnakeAndLadderMove(5));
        game3.turn(3,new SnakeAndLadderMove(1));
        System.out.println("Game 3 Status : " + (game3.getWinner() == -1 ? "Game is In-Progress" : game3.getWinner()));



    }
}
