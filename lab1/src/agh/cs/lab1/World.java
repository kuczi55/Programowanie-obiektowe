package agh.cs.lab1;

import java.util.Arrays;

public class World {
    public static void main(String[] args){
        System.out.println("Start");
        for(String argument : args ){
            if(argument != args[args.length-1])
                System.out.print(argument + ", ");
            else
                System.out.println(argument);
        }
        Direction arguments[] = convert(args);
        run(arguments);
        System.out.println("Stop");
    }
    public static void run(Direction[] arguments){
        for(Direction argument : arguments)
            switch (argument) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tylu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skreca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skreca w lewo");
                    break;
            }
    }

    public static Direction[] convert(String[] args){
        Direction arguments[] = new Direction[args.length];
        int i = 0;
        for(String itr : args){
            switch (itr){
                case "f":
                   arguments[i++] = Direction.FORWARD;
                   break;
                case "b":
                    arguments[i++] = Direction.BACKWARD;
                    break;
                case "r":
                    arguments[i++] = Direction.RIGHT;
                    break;
                case "l":
                    arguments[i++] = Direction.LEFT;
                    break;
                default:
                    break;
            }
        }
        return Arrays.copyOfRange(arguments, 0, i);
    }
}