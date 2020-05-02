package com.lld;

public interface BoardGame {
    public void resetBoard();

    /**
     * @return It will return winning player Id else -1
     */
    public int getWinner();

    /**
     * @param playerId PlayerId
     * @param move Number of step player is allowed to move
     * @return
     */
    public int turn(int playerId, Move move);

    /**
     * @param count Undo last 'count' moves
     */
    public void undoMove(int count);
}
