package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    List<Grass> grass = new ArrayList<>();

    public GrassField(int n) {
        Random generator = new Random();
        int a, b, i = 0;
        while(i<n) {
            a = generator.nextInt((int)sqrt(n*10));
            b = generator.nextInt((int)sqrt(n*10));
            Vector2d possiblePosition = new Vector2d(a, b);
            if(!isOccupied(possiblePosition)) {
                this.grass.add(new Grass(possiblePosition));
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
        //boolean isAnimal = false;
        for(Animal itr : this.animals){
            if(possiblePosition.equals(itr.getPosition())) {
                return false;
            }
        }
       // if(isOccupied(possiblePosition) && isAnimal)
            //return false;
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d possiblePosition) {
        if(super.isOccupied(possiblePosition)) return true;
        for(Grass itr2 : this.grass){
            if(itr2.getPosition().equals(possiblePosition)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object != null) return object;
        for(Grass itr2 : this.grass)
            if(itr2.getPosition().equals(position)) return itr2;
        return null;
    }
}
