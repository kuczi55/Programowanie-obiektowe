package agh.cs.lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();

    @Override
    public boolean place(Animal newAnimal) {
        if(!canMoveTo(newAnimal.getPosition()))
            throw new IllegalArgumentException("Position " + newAnimal.getPosition() +  " is occupied.");
        animals.add(newAnimal);
        animalsMap.put(newAnimal.getPosition(), newAnimal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int size = this.animals.size();
        if(size == 0) return;
        int itr = 0;
        for(MoveDirection direction : directions){
            //this.animals.get(itr++ % size).move(direction);
            Animal movingAnimal = this.animals.get(itr++ % size);
            this.animalsMap.remove(movingAnimal.getPosition());
            movingAnimal.move(direction);
            this.animalsMap.put(movingAnimal.getPosition(), movingAnimal);
            //itr = (itr + 1) % size;
        }
    }

    @Override
    public boolean isOccupied(Vector2d possiblePosition) {
        //for(Animal itr : this.animals){
            //if(itr.getPosition().equals(possiblePosition)) return true;
       // }
       // return false;
        return objectAt(possiblePosition) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
       // for(Animal itr : this.animals)
          //  if(itr.getPosition().equals(position)) return itr;
       // return null;
        return this.animalsMap.get(position);
    }
}
