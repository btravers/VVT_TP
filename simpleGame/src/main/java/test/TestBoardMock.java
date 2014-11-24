package test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import static org.mockito.Mockito.*;

import simpleGame.core.Pawn;
import simpleGame.core.Board;

import static org.junit.Assert.*;

/**
 * Created by btravers on 24/11/14.
 */
public class TestBoardMock extends TestBoard {

    @Before
    public void setup() {
        super.setup();
        pawn = mock(Pawn.class);
    }
}
