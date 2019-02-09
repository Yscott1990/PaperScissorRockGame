package au.com.imc.test2.model;

/**
 * Abstract play class represents common player to be extended.
 *
 * WinRounds: number of rounds that current player has won
 * currentGesture: current gesture of current player for current round
 */
public abstract class AbstractPlayer {
    private int winRounds;
    private Gesture currentGesture;

    public AbstractPlayer() {
        this.winRounds = 0;
    }

    public void incrementWinRound() {
        ++this.winRounds;
    }

    public int getWinRounds() {
        return winRounds;
    }

    public void setWinRounds(int winRounds) {
        this.winRounds = winRounds;
    }

    public Gesture getCurrentGesture() {
        return currentGesture;
    }

    public void setCurrentGesture(Gesture currentGesture) {
        this.currentGesture = currentGesture;
    }
}
