package model.player;

import model.TicTacToeField;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }


    @Override
    public void makeAMove(TicTacToeField field, int marker) {
        boolean possibleMove = false;
        while (!possibleMove) {
            String[] coordinates = getCoordinatesFromUser();
            int y = Integer.parseInt(coordinates[0]) - 1;
            int x = Integer.parseInt(coordinates[1]) - 1;
            if (field.getDotValue(y, x) == 0) {
                possibleMove = true;
                field.setMark(y, x, marker);
            }
        }
    }

    private String[] getCoordinatesFromUser() {
        System.out.print("Ходит " + this.getName() + " (y,x): ");
        String input = scanner.nextLine();
        while (!input.matches("[1-3],[1-3]")) {
            System.out.print("Ход не возможен, повторите: ");
            input = scanner.nextLine();
        }
        return input.split(",");
    }
}
