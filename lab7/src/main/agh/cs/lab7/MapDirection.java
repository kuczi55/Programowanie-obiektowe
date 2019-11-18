package agh.cs.lab7;

enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(){
        switch(this) {
            case NORTH: return "Polnoc";
            case SOUTH: return "Poludnie";
            case WEST: return "Zachod";
            case EAST: return "Wschod";
        }
        return null;
    }

    public MapDirection next(){
        switch(this) {
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            case NORTH: return EAST;
        }
        return null;
    }

    public MapDirection previous(){
        switch(this) {
            case EAST: return NORTH;
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
        }
        return null;
    }

    public Vector2d toUnitVector() {
        switch(this) {
            case EAST: return new Vector2d(1,0);
            case NORTH: return new Vector2d(0,1);
            case WEST: return new Vector2d(-1, 0);
            case SOUTH: return new Vector2d(0, -1);
        }
        return null;
    }
}

