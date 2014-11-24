package test;

import org.junit.Before;
import org.junit.Test;
import simpleGame.core.Board;
import simpleGame.core.Game;
import simpleGame.core.Pawn;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestSequenceDiagram {


    @Test
    public void testIsGameOver() throws Exception {
        Board board = mock(Board.class);

        when(board.numberOfPawns()).thenReturn(2);
        when(board.maxGold()).thenReturn(3);

        Game game = new Game(board);

        assertTrue(game.isGameOver());

        verify(board).numberOfPawns();
        verify(board).maxGold();
    }

    @Test
    public void testMaxGold() throws Exception {
        Pawn pawn1 = mock(Pawn.class);
        Pawn pawn2 = mock(Pawn.class);
        when(pawn1.getGold()).thenReturn(1);
        when(pawn2.getGold()).thenReturn(3);

        when(pawn1.getX()).thenReturn(1);
        when(pawn1.getY()).thenReturn(1);
        when(pawn2.getX()).thenReturn(3);
        when(pawn2.getY()).thenReturn(3);

        Board board = new Board(0, 5, 5, 2, 2);
        board.addPawn(pawn1);
        board.addPawn(pawn2);

        assertEquals(3, board.maxGold());

        verify(pawn1).getGold();
        verify(pawn2).getGold();
    }
}