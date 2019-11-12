package agh.cs.lab6;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    List<Grass> grass = new ArrayList<>();
    private HashMap<Vector2d, Grass> grassMap = new LinkedHashMap<>();

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
                i++;
            }
        }
    }

    public Vector2d countLowerLeft() {
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
    }

    public String toString() {
        if(countLowerLeft().equals(null)) return "";
        return new MapVisualizer(this).draw(countLowerLeft(), countUpperRight());
    }

    @Override
    public boolean canMoveTo(Vector2d possiblePosition) {
//        boolean isAnimal = false;
//        for(Animal itr : this.animals){
//            if(possiblePosition.equals(itr.getPosition())) {
//                return false;
//            }
//        }
        if(this.animalsMap.get(possiblePosition) != null) return false;
       // if(isOccupied(possiblePosition) && isAnimal)
            //return false;
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d possiblePosition) {
        if(super.isOccupied(possiblePosition)) return true;
       // for(Grass itr2 : this.grass){
           // if(itr2.getPosition().equals(possiblePosition)) return true;
       // }
        if(objectAt(possiblePosition) != null) return true;
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object != null) return object;
        //for(Grass itr2 : this.grass)
          //  if(itr2.getPosition().equals(position)) return itr2;
        //return null;
        return this.grassMap.get(position);
    }


}
