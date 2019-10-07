package agh.cs.lab1;

import java.util.Arrays;

import static java.util.Arrays.*;

public class World {
    public static void main(String[] args){
        System.out.println("Start");
        for(String argument : args ){
            if(argument!=args[args.length-1])
                System.out.print(argument + ", ");
            else
                System.out.println(argument);
        }
        int i=0;
        int j=0;
        while(i<=args.length){
            if(i<args.length && (args[i].equals("f") || args[i].equals("b") || args[i].equals("r") || args[i].equals("l"))){
                i++;
            }
            else{
                while(j<i && j<args.length && !args[j].equals("f") && !args[j].equals("b") && !args[j].equals("r") && !args[j].equals("l")) j++;
                if(j<args.length) {
                    String temp[] = copyOfRange(args, j, i);
                    Direction arguments[] = convert(temp);
                    run(arguments);
                    if(i<args.length) j = i;

                }
                i++;
            }

        }

        System.out.println("Stop");
    }
    public static void run(Direction[] arguments){
        //System.out.println("Zwierzak idzie do przodu");
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
                default:
                    System.out.println("Podano nieprawidlowy kierunek");
                    break;
            }
        }
        //System.out.println();
    //}
    public static Direction[] convert(String[] args){
        Direction arguments[] = new Direction[args.length];
        for(int i=0; i<args.length; i++){
            //System.out.println(args[i]);
            if(args[i].equals("f")) arguments[i]=Direction.FORWARD;
            else if(args[i].equals("b")) arguments[i]=Direction.BACKWARD;
            else if(args[i].equals("r")) arguments[i]=Direction.RIGHT;
            else if(args[i].equals("l")) arguments[i]=Direction.LEFT;
        }
        return arguments;
    }
}
