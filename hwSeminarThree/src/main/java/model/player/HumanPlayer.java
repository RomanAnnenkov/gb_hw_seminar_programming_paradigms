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
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            if (field.getDotValue(x, y) == 0) {
                possibleMove = true;
                field.setMark(x, y, marker);
            }
        }
    }

    private String[] getCoordinatesFromUser() {
        System.out.print("Ходит " + this.getName() + " (x,y): ");
        String input = scanner.nextLine();
        while (!input.matches("[0-2],[0-2]")) {
            System.out.print("Ход не возможен, повторите: ");
            input = scanner.nextLine();
        }
        return input.split(",");
    }
}
