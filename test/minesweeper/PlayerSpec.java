package minesweeper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerSpec {

    @Test
    public void playerScoreShowIncreasesIfPlayerOpensBoxWithoutMine() throws PlayerDiedException {

        Game game = new Game(3,3);
        game.setMine(new Location(0,1));
        game.setMine(new Location(1,0));

        assertEquals(0,game.getScore());

        game.openBox(new Location(1,1));
        assertEquals(2,game.getScore());

        game.openBox(new Location(2,1));
        assertEquals(3,game.getScore());
    }

    @Test(expected = PlayerDiedException.class)
    public void playerDiesIfPlayerOpensBoxWithMine() throws PlayerDiedException {

        Game game = new Game(3,3);
        game.setMine(new Location(0,1));

        game.openBox(new Location(0,1));
    }
}
