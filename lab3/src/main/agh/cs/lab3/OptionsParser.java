package agh.cs.lab3;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parser(String[] pars) {
        int i = 0;
        MoveDirection[] conv =new MoveDirection[pars.length];
        for(String itr : pars){
            switch (itr){
                case "f":
                case "forward":
                    conv[i++] = MoveDirection.FORWARD;
                    break;
                case "b":
                case "backward":
                    conv[i++] = MoveDirection.BACKWARD;
                    break;
                case "r":
                case "right":
                    conv[i++] = MoveDirection.RIGHT;
                    break;
                case "l":
                case "left":
                    conv[i++] = MoveDirection.LEFT;
                    break;
                default:
                    break;
            }
        }
        return Arrays.copyOfRange(conv, 0, i);
    }
}
