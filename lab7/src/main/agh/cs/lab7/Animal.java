package agh.cs.lab7;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    List<IPositionChangeObserver> observer = new ArrayList<>();
    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public String toString(){
        switch(this.orientation) {
            case NORTH :
                return "N";
            case SOUTH :
                return "S";
            case EAST :
                return "E";
            case WEST :
                return "W";
        }
        return null;
    }

    public String toStringAll(){
        return "Orientacja: " + this.toString() + "\nPolozenie: " + this.position;
    }


    public void move(MoveDirection direction){
        switch(direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                Vector2d unit = this.position.add(this.orientation.toUnitVector());
                if(this.map.canMoveTo(unit)) {
                    this.positionChanged(this.position, unit);
                    this.position = unit;
                }
                break;
            case BACKWARD:
                unit = this.position.subtract(this.orientation.toUnitVector());
                if(this.map.canMoveTo(unit)) {
                    this.positionChanged(this.position, unit);
                    this.position = unit;
                }
                break;

            }
        }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observer.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observer.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver obs : this.observer) obs.positionChanged(oldPosition, newPosition);
    }
}
