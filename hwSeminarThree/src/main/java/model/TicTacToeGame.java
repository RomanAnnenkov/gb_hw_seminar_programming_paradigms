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
        this.field = new TicTacToeField();
    }

    public TicTacToeField getField() {
        return field;
    }

    public boolean isRoundOver() {
        String currentCombinations = field.getCombinations();
        if (currentCombinations.matches(".*(111|222).*")) {
            return true;
        }
        return !currentCombinations.matches(".*([01]{3}|[02]{3}).*");
    }

    public Player whoIsRoundWinner() {
        String combinations = field.getCombinations();
        field.clearField();
        if (combinations.contains("111")) {
            return playerOne;
        }
        if (combinations.contains("222")) {
            return playerTwo;
        }
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
