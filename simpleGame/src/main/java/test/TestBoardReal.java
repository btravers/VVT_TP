package test;

import org.junit.Before;
import simpleGame.core.Pawn;

/**
 * Created by btravers on 24/11/14.
 */
public class TestBoardReal extends TestBoard {

    @Before
    public void setup() {
        super.setup();
        pawn = new Pawn('a', 1, 1, board);
    }

}
