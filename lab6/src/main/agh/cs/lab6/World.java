package agh.cs.lab6;

public class World {
    public static void main(String[] args){
        try {
            MoveDirection[] directions = new OptionsParser().parser(args);

            IWorldMap map = new GrassField(10);
            Animal a = new Animal(map);
            Animal b = new Animal(map, new Vector2d(3, 4));
            Animal c = new Animal(map, new Vector2d(3, 4));
            map.place(a);
            map.place(b);
           // map.place(c);
            map.run(directions);
            System.out.println(a.toStringAll());
            System.out.println(b.toStringAll());
            System.out.println(map.toString());

            IWorldMap map1 = new RectangularMap(10, 5);
            Animal a1 = new Animal(map1);
            Animal b1 = new Animal(map1, new Vector2d(3, 4));
            map1.place(a1);
            map1.place(b1);
            map1.run(directions);
            System.out.println(a1.toStringAll());
            System.out.println(b1.toStringAll());
            System.out.println(map1.toString());
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.exit(2);
        }
    }
}
