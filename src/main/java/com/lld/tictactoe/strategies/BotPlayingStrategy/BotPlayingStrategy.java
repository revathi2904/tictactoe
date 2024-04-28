package com.lld.tictactoe.strategies.BotPlayingStrategy;

import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.models.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
