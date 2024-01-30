package model.player;

import model.TicTacToeField;

public abstract class Player {
    private String name;
    private int marker;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void makeAMove(TicTacToeField field, int marker);
}
