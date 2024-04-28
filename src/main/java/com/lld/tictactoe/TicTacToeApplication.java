package com.lld.tictactoe;

import com.lld.tictactoe.controllers.GameController;
import com.lld.tictactoe.controllers.Test;
import com.lld.tictactoe.models.*;
import com.lld.tictactoe.strategies.WinningStrategy.ColumnWinningStrategy;
import com.lld.tictactoe.strategies.WinningStrategy.DiagonalWinningStrategy;
import com.lld.tictactoe.strategies.WinningStrategy.RowWinningStrategy;
import com.lld.tictactoe.strategies.WinningStrategy.WinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args){
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        try{
            int dimensions = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(1L,"AB", new Symbol('X'), PlayerType.HUMAN));
            players.add(new Bot(2L,"GPT", new Symbol('O'),PlayerType.BOT, BotDifficultyLevel.EASY));
            List<WinningStrategy> winningStrategies = new ArrayList<>();
            winningStrategies.add(new ColumnWinningStrategy());
            winningStrategies.add(new RowWinningStrategy());
            winningStrategies.add(new DiagonalWinningStrategy());
            Game game = gameController.startGame(dimensions, players, winningStrategies);
            while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
                gameController.displayBoard(game);
                System.out.println("Do u want to do an undo (Y/N)");
                String ans = scanner.next();

                if(ans.equalsIgnoreCase("y")){
                    gameController.undo(game);
                    continue;
                }
                gameController.makeMove(game);
            }
            if(gameController.checkState(game).equals(GameState.DRAW))
                System.out.println("Game has been drawn");
            if(gameController.checkState(game).equals(GameState.WIN))
                System.out.println("Game has been won by "+ gameController.getWinner(game).getName());


        }catch(Exception e){
            System.out.println("Something went wrong in creating the game "+e);
        }


        SpringApplication.run(TicTacToeApplication.class, args);
    }

}
