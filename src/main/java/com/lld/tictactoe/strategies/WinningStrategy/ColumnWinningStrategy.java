package com.lld.tictactoe.strategies.WinningStrategy;

import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.models.Move;
import com.lld.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements  WinningStrategy{


    Map<Integer,Map<Symbol, Integer>> counts= new HashMap<>();

    // COLUMN wise count
    //{
    //{0 -> {X->0, O -> 0}}
    //{1 -> {X->0, O -> 0}}
    //{2 -> {X->0, O -> 0}}
    //}

    @Override
    public boolean checkWinner(Board board, Move move){
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        if(!counts.containsKey(col)){
            counts.put(col,new HashMap<>());
        }

        Map<Symbol, Integer> colMap = counts.get(col);

        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }

        colMap.put(symbol,colMap.get(symbol) +1);

        if(colMap.get(symbol).equals(board.getSize())){
            return true;
        }
        return false;
    }

    @Override
    public void undo(Board board, Move move){
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer> colMap = counts.get(col);

        colMap.put(symbol,colMap.get(symbol) - 1);
    }

}
