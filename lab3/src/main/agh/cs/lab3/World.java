package agh.cs.lab3;

public class World {
    public static void main(String[] args){
        Animal a = new Animal();
        MoveDirection[] directions = OptionsParser.parser(args);
        for(MoveDirection dir : directions)
            a.move(dir);
        System.out.println(a);
    }
}
