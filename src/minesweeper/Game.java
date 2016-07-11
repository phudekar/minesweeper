package minesweeper;

import java.util.List;
import java.util.Optional;

public class Game {
    private final Board board;
    private int score;

    static final int MINE = 0;

    public Game(int rows, int columns) {
        this.board = new Board(rows, columns);
    }

    public int getScore() {
        return score;
    }

    public void openBox(Location location) throws PlayerDiedException {
        if (board.getValueAt(location).isPresent()
                && board.getValueAt(location).get() == MINE) {
            throw new PlayerDiedException(score);
        }

        int numberOfMines = getNumberOfMines(location);
        board.setValueAt(location, numberOfMines);
        score += numberOfMines;
    }

    public void setMine(Location location) {
        board.setValueAt(location, MINE);
    }

    private int getNumberOfMines(Location location) {
        List<Location> adjacentLocations = board.getAdjacentLocationsTo(location);
        int numberOfMines = 0;
        for (Location adjacentLocation : adjacentLocations) {
            Optional<Integer> value = board.getValueAt(adjacentLocation);
            if (value.isPresent() && value.get() == MINE)
                numberOfMines += 1;
        }
        return numberOfMines;
    }
}
