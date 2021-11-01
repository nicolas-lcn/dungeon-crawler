package controller;


import model.*;

import java.util.Random;

public class RandomController {

    public static final Random random = new Random();

    public static Direction randomDirection(){
        return Direction.values()[random.nextInt(4)];
    }

    public static Component randomComponent(){
        //TODO
        return null;
    }

    public static int randomPortalNumber(){ return random.nextInt(3) + 1 ;}

    public static Item randomItem(){
        //TODO
        return null;
    }

    public static int randomPosition(int max){return random.nextInt(max);}
}
