package model;

import model.player.Player;

public class TicTacToeGame {
    private final Player playerOne;
    private final Player playerTwo;
    private final TicTacToeField field;
    private int movesCount = 0;

    public TicTacToeGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.field = TicTacToeField.getInstance();
    }

    public TicTacToeField getField() {
        return field;
    }

    public boolean isRoundOver() {
        String currentCombinations = field.getCombinations();

        if (currentCombinations.contains("111") || currentCombinations.contains("222")) {
            return true;
        }
        return currentCombinations.matches("[0,1]{3}|[0,2]{3}");
    }

    public Player whoIsRoundWinner() {
        String winnerCombinations = field.getCombinations();

        long countOne = winnerCombinations.chars().filter(x -> x== '1').count();
        long countTwo = winnerCombinations.chars().filter(x -> x== '2').count();

        if (countOne > countTwo) {
            return playerOne;
        }
        if (countTwo > countOne) {
            return playerTwo;
        }
        field.clearField();
        return null;
    }

    public void nextPlayerMove() {
        movesCount++;
        if (movesCount % 2 != 0) {
            playerOne.makeAMove(field, 1);
        } else {
            playerTwo.makeAMove(field, 2);
        }
    }

}
