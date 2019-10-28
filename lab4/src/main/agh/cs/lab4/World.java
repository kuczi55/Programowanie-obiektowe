package agh.cs.lab4;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parser(args);
        IWorldMap map = new RectangularMap(10, 5);
        Animal a = new Animal(map);
        Animal b = new Animal(map,new Vector2d(3,4));
        map.place(a);
        map.place(b);
        map.run(directions);
        System.out.println(a.toStringAll());
        System.out.println(b.toStringAll());
    }
}
