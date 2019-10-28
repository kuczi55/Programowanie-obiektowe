package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    List<Animal> animals = new ArrayList<>();
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

    @Override
    public boolean place(Animal newAnimal) {
        if(!canMoveTo(newAnimal.getPosition()))
        return false;
        animals.add(newAnimal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int size = this.animals.size();
        if(size == 0) return;
        int itr = 0;
        for(MoveDirection direction : directions){
            this.animals.get(itr++ % size).move(direction);
        }
    }

    @Override
    public boolean isOccupied(Vector2d possiblePosition) {
        for(Animal itr : this.animals){
            if(itr.getPosition().equals(possiblePosition)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal itr : this.animals)
            if(itr.getPosition().equals(position)) return itr;
        return null;
    }
}
