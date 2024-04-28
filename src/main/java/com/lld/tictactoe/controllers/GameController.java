package com.lld.tictactoe.controllers;

import com.lld.tictactoe.Exception.BotCountException;
import com.lld.tictactoe.Exception.PlayerCountException;
import com.lld.tictactoe.Exception.SymbolCountException;
import com.lld.tictactoe.models.Game;
import com.lld.tictactoe.models.GameState;
import com.lld.tictactoe.models.Player;
import com.lld.tictactoe.strategies.WinningStrategy.WinningStrategy;

import java.util.List;
public class GameController {
    public Game startGame(int dimension, List<Player> players,
                          List<WinningStrategy> winningStrategies)
                          throws PlayerCountException, BotCountException, SymbolCountException {
        //before creating original Game object builder pattern helps in validating the parameters
        // getBuilder is a method in Game class which returns the nested  Builder class
        return  Game.getBuilder().setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build(); // build method validates the parameters passed and return the Game object(this triggeres game constructor)
    }

    public void makeMove(Game game){
        game.makeMove();

    }
    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameState checkState(Game game){
        return game.getGameState();

    }

    public void undo(Game game){
        game.undo();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
