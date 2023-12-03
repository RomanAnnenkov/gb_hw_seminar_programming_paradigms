package view;

import model.TicTacToeField;
import model.TicTacToeGame;
import model.player.HumanPlayer;
import model.player.Player;
import model.player.RobotPlayer;

import java.util.Scanner;

public class ConsoleView implements IView {
    Scanner scanner = new Scanner(System.in);
    TicTacToeGame game;

    @Override
    public void run() {
        System.out.println("Крестики-нолики.");
        System.out.print("Введите количество игроков: ");
        String input = scanner.nextLine();
        while (!input.matches("[0-2]")) {
            System.out.print("Возможные значения(0,1,2), повторите ввод: ");
            input = scanner.nextLine();
        }
        switch (input) {
            case "0":
                game = new TicTacToeGame(new RobotPlayer("RobotP1"), new RobotPlayer("RobotP2"));
                break;
            case "1":
                game = new TicTacToeGame(new HumanPlayer(getPlayerName(1)), new RobotPlayer("RobotP2"));
                break;
            case "2":
                game = new TicTacToeGame(new HumanPlayer(getPlayerName(1)), new HumanPlayer(getPlayerName(2)));
        }

        while (true) {
            printField(game.getField());
            while (!game.isRoundOver()) {
                game.nextPlayerMove();
                printField(game.getField());
            }
            Player winner = game.whoIsRoundWinner();
            if (winner == null) {
                System.out.println("Ничья.");
            } else {
                System.out.println("<-------- Выиграл " + winner.getName() + " -------->");
            }

            System.out.print("Хотите продолжить играть?(y/n): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")) {
                return;
            }
            game.getField().clearField();
        }
    }

    public void printField(TicTacToeField field) {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print(i+1);
            for (int j = 0; j < 3; j++) {
                switch (field.getDotValue(i, j)) {
                    case 0:
                        System.out.print(" _");
                        break;
                    case 1:
                        System.out.print(" Х");
                        break;
                    case 2:
                        System.out.print(" O");
                }
            }
            System.out.println();
        }
    }

    public String getPlayerName(int marker) {
        System.out.print("Введите имя игрока" + marker + ": ");
        return scanner.nextLine();
    }

}
