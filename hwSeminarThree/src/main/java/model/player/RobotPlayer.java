package model.player;

import model.TicTacToeField;

public class RobotPlayer extends Player {
    public RobotPlayer(String name) {
        super(name);
    }

    @Override
    public void makeAMove(TicTacToeField field, int marker) {
        int centralPoint = 1;
        if (field.getDotValue(centralPoint, centralPoint) == 0) {
            move(centralPoint, centralPoint, marker, field);
            return;
        }

        String combinations = field.getCombinations();
        int indexCombination = findCombinationIndexForMakeMove(combinations, marker);

        int[] targetCombinationCoordinates = getCombinationCoordinates(indexCombination);

        for (int i = 0; i < targetCombinationCoordinates.length; i += 2) {
            int x = targetCombinationCoordinates[i];
            int y = targetCombinationCoordinates[i + 1];
            if (field.getDotValue(y, x) == 0) {
                move(y, x, marker, field);
                return;
            }
        }
    }

    public int findCombinationIndexForMakeMove(String combinations, int marker) {
        String[] combinationsArray = combinations.split(" ");
        for (int i = 0; i < combinationsArray.length; i++) {
            if (combinationsArray[i].matches(".*(110|011|101|220|022|202).*")) {
                return i;
            }
        }
        for (int i = 0; i < combinationsArray.length; i++) {
            String currentCombination = combinationsArray[i];
            if (currentCombination.matches(".*([0]{2}|0[1-2]0).*") && currentCombination.contains(Integer.toString(marker))) {
                return i;
            }
        }
        for (int i = 0; i < combinationsArray.length; i++) {
            String currentCombination = combinationsArray[i];
            if (currentCombination.contains("000")) {
                return i;
            }
        }
        for (int i = 0; i < combinationsArray.length; i++) {
            String currentCombination = combinationsArray[i];
            if (currentCombination.contains("0")) {
                return i;
            }
        }
        throw new RuntimeException("combination index for move not found");
    }

    private int[] getCombinationCoordinates(int combinationIndex) {
        return switch (combinationIndex) {
            case 0 -> new int[]{0, 0, 0, 1, 0, 2};
            case 1 -> new int[]{0, 0, 1, 0, 2, 0};
            case 2 -> new int[]{1, 0, 1, 1, 1, 2};
            case 3 -> new int[]{0, 1, 1, 1, 2, 1};
            case 4 -> new int[]{2, 0, 2, 1, 2, 2};
            case 5 -> new int[]{0, 2, 1, 2, 2, 2};
            case 6 -> new int[]{0, 0, 1, 1, 2, 2};
            case 7 -> new int[]{0, 2, 1, 1, 2, 0};
            default -> throw new RuntimeException("coordinates for this index not found");
        };
    }

    private void move(int y, int x, int marker, TicTacToeField field) {
        System.out.println("Ходит " + this.getName() + " (y,x): " + (y + 1) + "," + (x + 1));
        field.setMark(y, x, marker);
    }

}
