package com.lld.tictactoe.strategies.BotPlayingStrategy;

import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.models.Cell;
import com.lld.tictactoe.models.CellState;
import com.lld.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements  BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row: board.getCells()){
            for(Cell cell: row){
                if(cell. getCellState().equals(CellState.EMPTY))
                    return new Move(cell, null);
            }
        }

        return null;
    }
}
