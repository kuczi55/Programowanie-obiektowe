package agh.cs.lab6;

public class RectangularMap extends AbstractWorldMap {


    private static final Vector2d mapStart = new Vector2d(0,0);
    private Vector2d mapEnd;
    public RectangularMap(int width, int height){
        mapEnd = new Vector2d(width-1, height-1);
    }

    public String toString() {
        return new MapVisualizer(this).draw(this.mapStart, this.mapEnd);
    }


    @Override
    public boolean canMoveTo(Vector2d possiblePosition) {
        if(isOccupied(possiblePosition))
        return false;
        if(possiblePosition.follows(mapStart) && possiblePosition.precedes(mapEnd)) return true;
        return false;
    }
}
