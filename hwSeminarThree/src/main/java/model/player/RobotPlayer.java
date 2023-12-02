package model.player;

import model.TicTacToeField;

public class RobotPlayer extends Player {
    public RobotPlayer(String name) {
        super(name);
    }

    @Override
    public void makeAMove(TicTacToeField field, int marker) {
        String combinations = field.getCombinations();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.getDotValue(j, i) == 0) {
                    System.out.println("Ходит " + this.getName() + " (x,y): " + i + "," + j);
                    field.setMark(j, i, marker);
                    return;
                }
            }
        }
    }

    public boolean findDangerCombination(String combinations) {
        for (String combination : combinations.split(" ")) {
            return combination.matches("[0,1]{3}]");
        }
        return false;
    }

}
