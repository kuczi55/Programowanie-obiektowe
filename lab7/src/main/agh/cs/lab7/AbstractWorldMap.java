package agh.cs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();

    @Override
    public boolean place(Animal newAnimal) {
        if(!canMoveTo(newAnimal.getPosition()))
            throw new IllegalArgumentException("Position " + newAnimal.getPosition() +  " is occupied.");
        animals.add(newAnimal);
        animalsMap.put(newAnimal.getPosition(), newAnimal);
        newAnimal.addObserver(this);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int size = this.animals.size();
        if(size == 0) return;
        int itr = 0;
        for(MoveDirection direction : directions){
            Animal movingAnimal = this.animals.get(itr++ % size);
            //this.animalsMap.remove(movingAnimal.getPosition());
            movingAnimal.move(direction);
            //this.animalsMap.put(movingAnimal.getPosition(), movingAnimal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d possiblePosition) {
        return objectAt(possiblePosition) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animalsMap.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        //Animal aml = this.animalsMap.get(oldPosition);
        //Animal aml = this.animalsMap.remove(oldPosition);
        this.animalsMap.put(newPosition, this.animalsMap.remove(oldPosition));
    }

}
