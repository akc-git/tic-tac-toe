package test;

import main.TicTacToeGame;
import main.Move;
import org.junit.Assert;
import org.junit.Test;
import main.Player;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TicTacToeGameTest {

    @Test
    public void shouldPlaceOnBoardWhenUserEntersMove(){

        int x = 1;
        int y = 0;

        String[][] board = {{"X","O"," "},{" ", " ", " "},{" "," "," "}};

        TicTacToeGame game = new TicTacToeGame(board);
        Player player = game.getCurrentPlayer();
        Move move = new Move(x,y);
        game.playMove(move);

        Assert.assertEquals(player.getSymbol(), game.getSymbolAtPosition(x, y));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldFailWhenUserEntersAlreadyMarkedPositions() {
        int x = 1;
        int y = 0;

        String[][] board = {{"X","O"," "},{"X", " ", " "},{" "," "," "}};

        TicTacToeGame game = new TicTacToeGame(board);
        Move move = new Move(x,y);
        game.playMove(move);
    }

    @Test()
    public void shouldAnnounceWinnerWhenGameCompletes(){
        int x = 2;
        int y = 2;

        String[][] board = {{"X","O"," "},{" ", "X", " "},{" ","O"," "}};

        TicTacToeGame game = new TicTacToeGame(board);
        Move move = new Move(x,y);
        game.playMove(move);

        Assert.assertTrue(game.isOver());
    }

}