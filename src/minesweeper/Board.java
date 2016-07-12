package minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static minesweeper.Game.MINE;

public class Board {
    private int rows;
    private int columns;

    private Integer[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Integer[rows][columns];
    }

    public Optional<Integer> getValueAt(Location location) {
        if (locationExists(location))
            return Optional.ofNullable(grid[location.X][location.Y]);

        return Optional.empty();
    }

    private boolean locationExists(Location location) {
        return location.X >= 0 && location.X < rows
                && location.Y >= 0 && location.Y < columns;
    }

    public void setValueAt(Location location, Integer value) {
        grid[location.X][location.Y] = value;
    }

    public List<Location> getAdjacentLocationsTo(Location location) {
        List<Location> adjacentLocations = new ArrayList<>();

        for (int x = location.X - 1; x <= location.X + 1; x++) {
            for (int y = location.Y - 1; y <= location.Y + 1; y++) {
                if (x == location.X && y == location.Y)
                    continue;
                adjacentLocations.add(new Location(x, y));
            }
        }
        return adjacentLocations.stream()
                .filter(this::locationExists)
                .collect(Collectors.toList());
    }

    public boolean isMine(Location location) {
        Optional<Integer> optionalLocationValue = this.getValueAt(location);
        return optionalLocationValue.isPresent() && optionalLocationValue.get() == MINE;
    }
}
