package main;

import java.util.Scanner;

public class TicTacToeGameController {

    public static void main(String[] args){
        Input inputReader = new ConsoleInputReader();
        Move move;

        TicTacToeGame game = new TicTacToeGame();
        while(!game.isOver()){
            try {
                move = createMoveFromInput(inputReader.getNextMove());
                game.playMove(move);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

    }

    public static Move createMoveFromInput(String input) {
        int x,y;
        String[] ordinates = input.split("\\s+");
        if (ordinates.length != 2){
            throw new IllegalArgumentException("Enter 2 co-ordinates separated by space");
        }

        try {
            x = Integer.parseInt(ordinates[0]);
            y = Integer.parseInt(ordinates[1]);
        }catch (IllegalStateException e) {
            throw new IllegalArgumentException("Enter only numbers");
        }

        if(x > 2 || x < 0 || y > 2 || y < 0 ) {
            throw new IllegalArgumentException("co-ordinates should be between [0,2]");
        }

        return new Move(x,y);
    }
}
