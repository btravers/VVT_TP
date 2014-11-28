package test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import simpleGame.core.Pawn;
import simpleGame.core.Board;

import static org.junit.Assert.*;
/**
 * Created by btravers on 24/11/14.
 */

public abstract class TestBoard {
    Pawn pawn;
    Board board;

    int sizeX = 5, sizeY = 5;
    int bonusX = 2, bonusY = 2;

    @Before
    public void setup() {
        board = new Board(0, sizeX, sizeY, bonusX, bonusY);
    }

    public void testGetXSize() throws Exception {
        assertEquals(sizeX, board.getXSize());
    }

    @Test
    public void testGetYSize() throws Exception {
        assertEquals(sizeY, board.getYSize());
    }

    @Test
    public void testGetSquareContentEmpty() throws Exception {
        assertNull(board.getSquareContent(1,1));
    }

    @Test
    public void testGetSquareContentWithPawn() throws Exception {
        board.addPawn(pawn);
        assertEquals(pawn, board.getSquareContent(pawn.getX(), pawn.getY()));
    }

    @Test
    public void testRemovePawn() throws Exception {
        board.addPawn(pawn);
        board.removePawn(pawn);
        assertNull(board.getSquareContent(pawn.getX(), pawn.getY()));
    }

    @Test
    public void testAddPawn() throws Exception {
        board.addPawn(pawn);
        assertEquals(pawn, board.getSquareContent(pawn.getX(), pawn.getY()));
    }

    @Test
    public void testIsBonusSquare() throws Exception {
        assertTrue(board.isBonusSquare(bonusX, bonusY));

        assertFalse(board.isBonusSquare(bonusX-1, bonusY-1));
    }


    @Test
    public void testNumberOfPawns() throws Exception {
        assertEquals(0, board.numberOfPawns());
        board.addPawn(pawn);
        assertEquals(1, board.numberOfPawns());
    }

    @Test
    public void testGetNextPawn() throws Exception {
        board.addPawn(pawn);
        assertEquals(pawn, board.getNextPawn());
    }

    @Test
    public void testRemoveAllPawns() throws Exception {
        board.addPawn(pawn);
        board.removeAllPawns();
        assertEquals(0, board.numberOfPawns());
    }
}
