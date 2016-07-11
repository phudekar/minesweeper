package minesweeper;

public class PlayerDiedException extends Exception{
    private final int finalScore;

    public PlayerDiedException(int score){
        super("Player Died");
        this.finalScore = score;
    }

    public int getFinalScore() {
        return finalScore;
    }
}
