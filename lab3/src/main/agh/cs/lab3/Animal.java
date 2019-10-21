package agh.cs.lab3;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){
        return "Orientacja: " + orientation.toString() + "\nPolozenie: " + position;
    }

    public boolean InBox(Vector2d tmp) {
        return tmp.follows(new Vector2d(0,0)) && tmp.precedes(new Vector2d(4,4));

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
                Vector2d unit=this.position.add(this.orientation.toUnitVector());
                if(InBox(unit)) this.position=unit;
                break;
            case BACKWARD:
                unit=this.position.subtract(this.orientation.toUnitVector());
                if(InBox(unit)) this.position=unit;
                break;

            }
        }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }
}
