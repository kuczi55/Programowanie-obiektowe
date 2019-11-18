package agh.cs.lab7;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    List<Grass> grass = new ArrayList<>();
    private HashMap<Vector2d, Grass> grassMap = new LinkedHashMap<>();
    public MapBoundary mapBoundary = new MapBoundary();
    public GrassField(int n) {
        Random generator = new Random();
        int a, b, i = 0;
        while(i<n) {
            a = generator.nextInt((int)sqrt(n*10));
            b = generator.nextInt((int)sqrt(n*10));
            Vector2d possiblePosition = new Vector2d(a, b);
            if(!isOccupied(possiblePosition)) {
                Grass g = new Grass(possiblePosition);
                this.grass.add(g);
                this.grassMap.put(g.getPosition(), g);
                mapBoundary.addToSets(possiblePosition);
                i++;
            }
        }
    }

   /* public Vector2d countLowerLeft() {
        Vector2d lowerLeft = null;
        for(Animal itr1 : this.animals){
            if(lowerLeft == null) lowerLeft = itr1.getPosition();
            else lowerLeft = lowerLeft.lowerLeft(itr1.getPosition());
        }
        for(Grass itr2 : this.grass){
            if(lowerLeft == null) lowerLeft = itr2.getPosition();
            else lowerLeft = lowerLeft.lowerLeft(itr2.getPosition());
        }
        return lowerLeft;
    }

    public Vector2d countUpperRight() {
        Vector2d upperRight = null;
        for(Animal itr1 : this.animals){
            if(upperRight == null) upperRight = itr1.getPosition();
            else upperRight = upperRight.upperRight(itr1.getPosition());
        }
        for(Grass itr2 : this.grass){
            if(upperRight == null) upperRight = itr2.getPosition();
            else upperRight = upperRight.upperRight(itr2.getPosition());
        }
        return upperRight;
    } */

    public String toString() {
        if(this.animals.isEmpty() && this.grass.isEmpty()) throw new IllegalArgumentException("No objects");;
        return new MapVisualizer(this).draw(mapBoundary.lowerLeftCorner(), mapBoundary.upperRightCorner());
    }

    @Override
    public boolean place(Animal newAnimal) {
        if(super.place(newAnimal)) {
            newAnimal.addObserver(mapBoundary);
            mapBoundary.addToSets(newAnimal.getPosition());
            return true;
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d possiblePosition) {
        if(this.animalsMap.get(possiblePosition) != null) return false;
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d possiblePosition) {
        if(super.isOccupied(possiblePosition)) return true;
        if(objectAt(possiblePosition) != null) return true;
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object != null) return object;
        return this.grassMap.get(position);
    }


}
