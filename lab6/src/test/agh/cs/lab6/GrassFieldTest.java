package agh.cs.lab6;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class GrassFieldTest {

    public static Animal a,b,c,d,e, f, g;
    public static IWorldMap map;

    @Before
    public void setUp() {
        map = new GrassField(10);
        a = new Animal(map);
        b = new Animal(map, new Vector2d(5,5));
        c = new Animal(map, new Vector2d(3,3));
        d = new Animal(map, new Vector2d(10,2));
        e = new Animal(map, new Vector2d(-1,-2));
        f = new Animal(map, new Vector2d(3,3));
        g = new Animal(map, new Vector2d(-3,3));
    }

    @Test
    public void canMoveToTest() {
        map.place(a);
        map.place(b);
        map.place(c);
        Assert.assertTrue(map.canMoveTo(new Vector2d(2,3)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(0,0)));
        Assert.assertFalse(map.canMoveTo(a.getPosition()));
        Assert.assertFalse(map.canMoveTo(c.getPosition()));
        Assert.assertTrue(map.canMoveTo(new Vector2d(10,7)));
    }

    @Test
    public void placeTest() {
        Assert.assertTrue(map.place(a));
        Assert.assertTrue(map.place(b));
        Assert.assertTrue(map.place(c));
        Assert.assertTrue(map.place(d));
        Assert.assertTrue(map.place(e));
        //map.place(c);
        //Assert.assertFalse(map.place(f));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illPlaceTest() {
        map.place(c);
        map.place(f);
    }

    @Test
    public void runTest() {
        map.place(a);
        map.place(b);
        map.place(c);
        String[] moves1 = new String[] {"l", "l", "r", "f", "l", "f", "f", "f", "f", "f", "f", "l"};
        map.run(OptionsParser.parser(moves1));
        Assert.assertEquals(a.getPosition(), new Vector2d(-1,2));
        Assert.assertEquals(b.getPosition(), new Vector2d(5,4));
        Assert.assertEquals(c.getPosition(), new Vector2d(5,3));
        Assert.assertEquals(a.getOrientation(), MapDirection.WEST);
        Assert.assertEquals(b.getOrientation(), MapDirection.SOUTH);
        Assert.assertEquals(c.getOrientation(), MapDirection.NORTH);
        String[] moves2 = new String[] {"l", "l", "r", "l", "l", "r", "f", "f", "f", "f", "f", "r", "f", "f", "f", "f", "r", "f"};
        map.run(OptionsParser.parser(moves2));
        Assert.assertEquals(a.getPosition(), new Vector2d(3,2));
        Assert.assertEquals(b.getPosition(), new Vector2d(5,7));
        Assert.assertEquals(c.getPosition(), new Vector2d(4,2));
        Assert.assertEquals(a.getOrientation(), MapDirection.EAST);
        Assert.assertEquals(b.getOrientation(), MapDirection.EAST);
        Assert.assertEquals(c.getOrientation(), MapDirection.WEST);
    }

    @Test
    public void isOccupiedTest() {
        map.place(a);
        map.place(b);
        Assert.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assert.assertTrue(map.isOccupied(new Vector2d(5,5)));
        map.place(c);
        Assert.assertTrue(map.isOccupied(f.getPosition()));
        Assert.assertFalse(map.isOccupied(new Vector2d(-5,0)));
    }

    @Test
    public void objectAtTest() {
        map.place(a);
        map.place(b);
        Assert.assertEquals(a, map.objectAt(new Vector2d(2,2)));
        Assert.assertEquals(b, map.objectAt(new Vector2d(5,5)));
        Assert.assertEquals(null, map.objectAt(new Vector2d(-3,3)));
        map.place(g);
        Assert.assertEquals(g, map.objectAt(new Vector2d(-3,3)));
    }
}
