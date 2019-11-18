package agh.cs.lab7;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AnimalTest {

    private Animal a,b,c,d;
    private IWorldMap map;
    private MapBoundary mapBoundary;

    @Before
    public void testingObjects() {
        this.map = new RectangularMap(6,5);
        this.mapBoundary = new MapBoundary();

        a = new Animal(map);
        b = new Animal(map, new Vector2d(2,3));
        c = new Animal(map, new Vector2d(5,4));
        d = new Animal(map, new Vector2d(0,0));

        map.place(a);
        map.place(b);
        map.place(c);
        map.place(d);

        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.RIGHT);
        a.move(MoveDirection.BACKWARD); //(1,2)

        b.move(MoveDirection.LEFT);
        b.move(MoveDirection.FORWARD);
        b.move(MoveDirection.LEFT);
        b.move(MoveDirection.FORWARD); //(1,3)

        c.move(MoveDirection.FORWARD);
        c.move(MoveDirection.RIGHT);
        c.move(MoveDirection.FORWARD); //(5,4)

        d.move(MoveDirection.BACKWARD);
        d.move(MoveDirection.LEFT);
        d.move(MoveDirection.FORWARD); //(0,0)
    }

    @Test
    public void orientationTest(){
        Assert.assertEquals(a.getOrientation(), MapDirection.EAST);
        Assert.assertEquals(b.getOrientation(), MapDirection.SOUTH);
        Assert.assertEquals(c.getOrientation(), MapDirection.EAST);
        Assert.assertEquals(d.getOrientation(), MapDirection.WEST);
    }

    @Test
    public void directionTest(){
        Assert.assertEquals(a.getPosition(), new Vector2d(1,2));
        Assert.assertEquals(b.getPosition(), new Vector2d(1,3));
        Assert.assertEquals(c.getPosition(), new Vector2d(5,4));
        Assert.assertEquals(d.getPosition(), new Vector2d(0,0));
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals(a.toString(), "E");
        Assert.assertEquals(b.toString(), "S");
        Assert.assertEquals(c.toString(), "E");
        Assert.assertEquals(d.toString(), "W");
    }

    @Test
    public void toStringTestAll(){
        Assert.assertEquals(a.toStringAll(), "Orientacja: E" + "\nPolozenie: (1,2)");
        Assert.assertEquals(b.toStringAll(), "Orientacja: S" + "\nPolozenie: (1,3)");
        Assert.assertEquals(c.toStringAll(), "Orientacja: E" + "\nPolozenie: (5,4)");
        Assert.assertEquals(d.toStringAll(), "Orientacja: W" + "\nPolozenie: (0,0)");
    }

    @Test
    public void addObserverTest(){
        a.addObserver(mapBoundary);
        Assert.assertEquals(2, a.observer.size());
        b.addObserver(mapBoundary);
        b.addObserver(mapBoundary);
        Assert.assertEquals(3, b.observer.size());
    }

    @Test
    public void removeObserverTest(){
        a.removeObserver(a.observer.get(0));
        Assert.assertEquals(0, a.observer.size());
        b.addObserver(mapBoundary);
        b.removeObserver(mapBoundary);
        Assert.assertEquals(1, b.observer.size());
    }
}
