package agh.cs.lab3;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class AnimalTest {

    Animal a,b,c,d,e,f;

    @Before
    public void testEle() {
        String[] aMoves = new String[]{"forward", "r", "f", "b"};
        a = new Animal();
        MoveDirection[] aConMoves = OptionsParser.parser(aMoves);
        for(MoveDirection dir : aConMoves)
            a.move(dir);
        String[] bMoves = new String[]{"forward", "f", "f", "po", "forward", "sth", "left"};
        b = new Animal();
        MoveDirection[] bConMoves = OptionsParser.parser(bMoves);
        for(MoveDirection dir : bConMoves)
            b.move(dir);
        String[] cMoves = new String[]{"right", "b", "backward", "b", "b", "tak", "r"};
        c = new Animal();
        MoveDirection[] cConMoves = OptionsParser.parser(cMoves);
        for(MoveDirection dir : cConMoves)
            c.move(dir);
        String[] dMoves = new String[]{"b", "backward", "b", "nie", "poco", "b", "l", "dlaczego", "left", "backward"};
        d = new Animal();
        MoveDirection[] dConMoves = OptionsParser.parser(dMoves);
        for(MoveDirection dir : dConMoves)
            d.move(dir);
        String[] eMoves = new String[]{"right", "f", "n", "r", "forward", "l", "f", "f", "forward"};
        e = new Animal();
        MoveDirection[] eConMoves = OptionsParser.parser(eMoves);
        for(MoveDirection dir : eConMoves)
            e.move(dir);
        String[] fMoves = new String[]{"forward", "l", "f", "r", "f", "l", "left", "b", "forward"};
        f = new Animal();
        MoveDirection[] fConMoves = OptionsParser.parser(fMoves);
        for(MoveDirection dir : fConMoves)
            f.move(dir);
    }

    @Test
    public void orientationTest(){
        Assert.assertEquals(a.getOrientation(), MapDirection.EAST);
        Assert.assertEquals(b.getOrientation(), MapDirection.WEST);
        Assert.assertEquals(c.getOrientation(), MapDirection.SOUTH);
        Assert.assertEquals(d.getOrientation(), MapDirection.SOUTH);
        Assert.assertEquals(e.getOrientation(), MapDirection.EAST);
        Assert.assertEquals(f.getOrientation(), MapDirection.SOUTH);
    }

    @Test
    public void directionTest(){
        Assert.assertEquals(a.getPosition(), new Vector2d(2,3));
        Assert.assertEquals(b.getPosition(), new Vector2d(2,4));
        Assert.assertEquals(c.getPosition(), new Vector2d(0,2));
        Assert.assertEquals(d.getPosition(), new Vector2d(2,1));
        Assert.assertEquals(e.getPosition(), new Vector2d(4,1));
        Assert.assertEquals(f.getPosition(), new Vector2d(1,3));
    }
}
