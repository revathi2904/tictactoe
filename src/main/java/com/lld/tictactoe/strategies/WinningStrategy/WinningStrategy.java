package com.lld.tictactoe.strategies.WinningStrategy;

import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move move);
    public void undo(Board board, Move move);
}
