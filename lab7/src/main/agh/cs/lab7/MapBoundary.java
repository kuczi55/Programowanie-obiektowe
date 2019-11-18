package agh.cs.lab7;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {

    private  class XComparator implements Comparator<Vector2d> {

        @Override
        public int compare(Vector2d v1, Vector2d v2) {
            if (v1.x > v2.x) return 1;
            else if (v1.x == v2.x) return v1.y - v2.y;
            return -1;
        }
    }

    private  class YComparator implements Comparator<Vector2d> {

        @Override
        public int compare(Vector2d v1, Vector2d v2) {
            if (v1.y > v2.y) return 1;
            else if (v1.y == v2.y) return v1.x - v2.x;
            return -1;
        }
    }

    protected SortedSet<Vector2d> xAxis;
    protected SortedSet<Vector2d> yAxis;

    public MapBoundary() {
        xAxis = new TreeSet<>(new XComparator());
        yAxis = new TreeSet<>(new YComparator());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xAxis.remove(oldPosition);
        xAxis.add(newPosition);
        yAxis.remove(oldPosition);
        yAxis.add(newPosition);
    }

    public void addToSets(Vector2d newVector2d){
        xAxis.add(newVector2d);
        yAxis.add(newVector2d);
    }

    public Vector2d lowerLeftCorner() {
        return new Vector2d(xAxis.first().x, yAxis.first().y);
    }

    public Vector2d upperRightCorner() {
        return new Vector2d(xAxis.last().x, yAxis.last().y);
    }
}
