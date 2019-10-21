package agh.cs.lab3;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class OptionsParserTest {

    MoveDirection[] t1, t2, t3, t4, t5, t6;
    MoveDirection[] aConMoves, bConMoves, cConMoves, dConMoves, eConMoves, fConMoves;

    @Before
    public void testStr() {
        String[] aMoves = new String[]{"forward", "r", "f", "b"};
        aConMoves = OptionsParser.parser(aMoves);
        String[] bMoves = new String[]{"forward", "f", "f", "po", "forward", "sth", "left"};
        bConMoves = OptionsParser.parser(bMoves);
        String[] cMoves = new String[]{"right", "b", "backward", "b", "b", "tak", "r"};
        cConMoves = OptionsParser.parser(cMoves);
        String[] dMoves = new String[]{"b", "backward", "b", "nie", "poco", "b", "l", "dlaczego", "left", "backward"};
        dConMoves = OptionsParser.parser(dMoves);
        String[] eMoves = new String[]{"right", "f", "n", "r", "forward", "l", "f", "f", "forward"};
        eConMoves = OptionsParser.parser(eMoves);
        String[] fMoves = new String[]{"forward", "l", "f", "r", "f", "l", "left", "b", "forward"};
        fConMoves = OptionsParser.parser(fMoves);

        t1 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.BACKWARD};
        t2 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT};
        t3 = new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        t4 = new MoveDirection[]{MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.BACKWARD};
        t5 = new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        t6 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.FORWARD};
    }

    @Test
    public void parserTest(){
        Assert.assertArrayEquals(aConMoves, t1);
        Assert.assertArrayEquals(bConMoves, t2);
        Assert.assertArrayEquals(cConMoves, t3);
        Assert.assertArrayEquals(dConMoves, t4);
        Assert.assertArrayEquals(eConMoves, t5);
        Assert.assertArrayEquals(fConMoves, t6);
    }
}
