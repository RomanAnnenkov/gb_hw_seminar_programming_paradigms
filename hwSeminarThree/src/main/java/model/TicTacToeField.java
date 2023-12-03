package model;

import java.util.Arrays;

public class TicTacToeField {
    private final int[][] field;
    private String combinations;
    private boolean renewCombinations = true;

    public TicTacToeField() {
        field = new int[3][3];
    }

    public String getCombinations() {
        if (renewCombinations) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < field.length; i++) {
                builder.append(field[i][0]).append(field[i][1]).append(field[i][2]).append(" ");
                builder.append(field[0][i]).append(field[1][i]).append(field[2][i]).append(" ");
            }
            builder.append(field[0][0]).append(field[1][1]).append(field[2][2]).append(" ");
            builder.append(field[0][2]).append(field[1][1]).append(field[2][0]);

            combinations = builder.toString();
            renewCombinations = false;
        }
        return combinations;
    }

    public void setMark(int y, int x, int mark) {
        field[x][y] = mark;
        renewCombinations = true;
    }

    public int getDotValue(int y, int x) {
        return field[x][y];
    }


    public void clearField() {
        for (int[] horizontalMoves : field) {
            Arrays.fill(horizontalMoves, 0);
        }
    }

}
