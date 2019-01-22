package main;

public class TicTacToeGame {

    private Player player1;
    private Player player2;
    private boolean gameOver = false;

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    Player currentPlayer;
    String[][] board = new String[3][3];

    public TicTacToeGame() {
        this.player1 = new Player("Palyer1", "X");
        this.player2 = new Player("Player2", "O");
        this.currentPlayer = player1;
    }

    public void playMove(Move move) throws IllegalStateException {
        validateMove(move);
        board[move.getX()][move.getY()] = getCurrentPlayer().getSymbol();
        checkVictoryCondition();

        switchPlayers();
    }

    private void checkVictoryCondition() {

        String symbol;

        //Check for Columns
        for (int j = 0; j < 3; j++) {
            symbol = getSymbolAtPosition(0, j);
            for (int i = 0; i < 3; i++) {
                if (getSymbolAtPosition(i, j) != symbol) {
                    break;
                }
            }
            gameOver = true;
            return;
        }

        //Check for Rows
        for (int i = 0; i < 3; i++) {
            symbol = getSymbolAtPosition(i, 0);
            for (int j = 0; j < 3; j++) {
                if (getSymbolAtPosition(i, j) != symbol) {
                    break;
                }
            }
            gameOver = true;
            return;
        }

        //Check for Diagnols
        symbol = getSymbolAtPosition(0, 0);
        for (int i = 0; i < 3; i++) {
            if (getSymbolAtPosition(i, i) != symbol) {
                break;
            }
            gameOver = true;
            return;
        }

        symbol = getSymbolAtPosition(0, 2);
        for (int i = 2; i >= 0; i--) {
            if (getSymbolAtPosition(2-i, i) != symbol) {
                break;
            }
            gameOver = true;
            return;
        }

        //Check if its a tie
        for(int i=0; i<3; i++){
            for(int j=0; j<3 ; j++) {
                if(getSymbolAtPosition(i,j).equals(" ")){
                    gameOver = false;
                    return;
                }
            }
        }

        gameOver = true;

    }

    private void validateMove(Move move) {
        if( getSymbolAtPosition(move.getX(),move.getY()) != " ")
            throw new IllegalStateException();
    }

    private void switchPlayers() {
        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public TicTacToeGame(String[][] board) {
        this();
        this.board = board;
    }

    public String getSymbolAtPosition(int x, int y) {
      return board[x][y];
    }

    public void showBoard() {
      for(int i = 0; i< 3 ; i++) {
          for(int j=0; j<3; j++) {
              System.out.println(board[i][j]);
          }
      }

    }

    public boolean isOver() {
        return gameOver;
    }

    public void start(){

    }
}
