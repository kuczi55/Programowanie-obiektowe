package agh.cs.lab4;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class OptionsParserTest {

    MoveDirection[] t1, t2, t3, t4;
    MoveDirection[] t1Converted, t2Converted, t3Converted, t4Converted;

    @Before
    public void testStr() {
        String[] t1Moves = new String[]{"forward", "r", "f", "b"};
        String[] t2Moves = new String[]{"forward", "f", "f", "po", "forward", "sth", "left"};
        String[] t3Moves = new String[]{"right", "b", "backward", "b", "b", "tak", "r"};
        String[] t4Moves = new String[]{"b", "backward", "b", "nie", "poco", "b", "l", "dlaczego", "left", "backward"};

        t1Converted = OptionsParser.parser(t1Moves);
        t2Converted = OptionsParser.parser(t2Moves);
        t3Converted = OptionsParser.parser(t3Moves);
        t4Converted = OptionsParser.parser(t4Moves);

        t1 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.BACKWARD};
        t2 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT};
        t3 = new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        t4 = new MoveDirection[]{MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.BACKWARD};

    }

    @Test
    public void parserTest(){
        Assert.assertArrayEquals(t1Converted, t1);
        Assert.assertArrayEquals(t2Converted, t2);
        Assert.assertArrayEquals(t3Converted, t3);
        Assert.assertArrayEquals(t4Converted, t4);
    }
}
