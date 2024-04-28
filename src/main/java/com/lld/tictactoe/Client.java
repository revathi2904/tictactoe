package com.lld.tictactoe;

import com.lld.tictactoe.controllers.GameController;
import com.lld.tictactoe.models.Bot;
import com.lld.tictactoe.models.Game;
import com.lld.tictactoe.models.Player;
import com.lld.tictactoe.strategies.WinningStrategy.WinningStrategy;

import java.util.List;
import java.util.ArrayList;


public class Client {

    public static void main(String[] args){
        GameController gameController = new GameController();

        try{
            int dimensions = 3;
//            List<Player> players = new ArrayList<>();
//            players.add(new Player());
//            players.add(new Bot());
//            List<WinningStrategy> winningStrategies = new ArrayList<>();
//            Game game = gameController.startGame(dimensions, players, winningStrategies);

        }catch(Exception e){
            System.out.println("Something went wrong in creating the game "+e);
        }

   }
}
