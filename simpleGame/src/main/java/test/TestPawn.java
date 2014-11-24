package test;

import org.junit.Before;
import org.junit.Test;
import simpleGame.core.Board;
import simpleGame.core.Direction;
import simpleGame.core.Pawn;

import static org.junit.Assert.*;

public class TestPawn {

    Pawn pawn;
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(0, 5, 5, 2, 2);
        pawn = new Pawn('a', 1, 1, board);
        board.addPawn(pawn);
    }

    @Test
    public void testGetX() throws Exception {
        assertEquals(1, pawn.getX());
    }

    @Test
    public void testGetY() throws Exception {
        assertEquals(1, pawn.getY());
    }

    @Test
    public void testGetLetter() throws Exception {
        assertEquals('a', pawn.getLetter());
    }

    @Test
    public void testGetGold() throws Exception {
        assertEquals(0, pawn.getGold());
    }

    @Test
    public void testMove() throws Exception {
        Pawn p = new Pawn('b', 2, 2, board);
        board.addPawn(p);

        pawn.move(Direction.Up);
        assertTrue(1==pawn.getX() && 2==pawn.getY());

        pawn.move(Direction.Right);
        assertTrue(1==pawn.getX() && 2==pawn.getY());
    }

    @Test
    public void testIsDead() throws Exception {
        Pawn p = new Pawn('b', 1, 2, board);
        board.addPawn(p);

        while (pawn.getY() != 2) {
            pawn.move(Direction.Up);
        }

        assertTrue(p.isDead());
        assertFalse(pawn.isDead());
        assertTrue(pawn.getGold()==1);
    }
}