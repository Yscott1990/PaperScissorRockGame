package au.com.imc.test2.model;

/**
 * Extended Gesture enum represents Paper, Scissors and Rock
 *
 * Index is used for referencing the result SCHEMA
 * Alias is used for representing symbol in the UI
 */
public enum Gesture {

    PAPER(0, "PAPER"),
    SCISSORS(1, "SCISSORS"),
    ROCK(2, "ROCK");

    private int index;
    private String alias;

    Gesture(int index, String alias) {
        this.index = index;
        this.alias = alias;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
