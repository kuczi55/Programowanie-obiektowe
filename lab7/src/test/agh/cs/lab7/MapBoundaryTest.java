package agh.cs.lab7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapBoundaryTest {

    private MapBoundary mapBoundary;
    private Vector2d a, b, c, d;

    @Before
    public void setUp() {
        mapBoundary = new MapBoundary();
        a = new Vector2d(2, 2);
        b = new Vector2d(-5, 3);
        c = new Vector2d(6, 1);
        d = new Vector2d(100, 100);
    }

    @Test
    public void addToSetsTest() {
        mapBoundary.addToSets(a);
        Assert.assertEquals(1, mapBoundary.xAxis.size());
        mapBoundary.addToSets(b);
        Assert.assertEquals(2, mapBoundary.yAxis.size());
    }

    @Test
    public void lowerLeftCornerTest() {
        mapBoundary.addToSets(a);
        mapBoundary.addToSets(b);
        mapBoundary.addToSets(c);
        Assert.assertEquals(mapBoundary.lowerLeftCorner(), new Vector2d(-5, 1));
    }

    @Test
    public void upperRightCornerTest() {
        mapBoundary.addToSets(a);
        mapBoundary.addToSets(b);
        mapBoundary.addToSets(c);
        Assert.assertEquals(mapBoundary.upperRightCorner(), new Vector2d(6, 3));
    }

    @Test
    public void positionChangedTest() {
        mapBoundary.addToSets(a);
        mapBoundary.positionChanged(a, d);
        Assert.assertEquals(mapBoundary.xAxis.first(), d);
        Assert.assertEquals(mapBoundary.yAxis.first(), d);
    }
}
