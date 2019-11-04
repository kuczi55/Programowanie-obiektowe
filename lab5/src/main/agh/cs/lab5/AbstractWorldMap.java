package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();

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
