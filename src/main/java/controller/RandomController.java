package controller;


import model.*;
import model.components.Chest;
import model.components.Component;
import model.components.Monster;
import model.components.Trap;

import java.util.Random;

public class RandomController {

    public static final Random random = new Random();

    public static Direction randomDirection(){
        return Direction.values()[random.nextInt(4)];
    }

    public static Component randomComponent(){
        int componentNumber = 3;
        switch (random.nextInt(componentNumber)+1){
            case 1:
                return new Monster(3,2,new Weapon("Poor-Weapon", 0));
            case 2:
                return new Trap(random.nextInt(10));
            default:
                return new Chest(randomItem());
        }
    }

    public static int randomPortalNumber(){ return random.nextInt(3) + 1 ;}

    public static Item randomItem(){
        int itemNumber = 2;
        if(random.nextInt(itemNumber)==1){
            return new Weapon("Incredible Weapon", random.nextInt(5));
        }
        return new Potion("Vitality Potion", random.nextInt(5));
    }

    public static int randomPosition(int max){return random.nextInt(max);}
}
