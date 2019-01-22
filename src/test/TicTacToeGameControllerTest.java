package test;


import main.TicTacToeGameController;
import main.Move;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TicTacToeGameControllerTest {

  @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenLessThan2CoOrdinatesInput(){

      String input = "3";
      Move move = TicTacToeGameController.createMoveFromInput(input);
  }

  @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenCoOrdinatesOutOfBound(){

      String input =  "5 1";
      Move move = TicTacToeGameController.createMoveFromInput(input);
  }

  @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenNumbersAreNotInput() {

      String input = "a b";
      Move move = TicTacToeGameController.createMoveFromInput(input);
  }


}