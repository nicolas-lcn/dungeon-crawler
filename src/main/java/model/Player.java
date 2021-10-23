package model;

import view.ConsoleView;
import view.View;

public class Player extends Character {

    public Player(int strength, int vitality) {
        super(strength, vitality);
    }

    public void goNorth() {
        //TODO
    }
    public void goSouth() {
        //TODO
    }

    public void goEast() {
        //TODO
    }
    public void goWest() {
        //TODO
    }

    @Override
    public void attack(Character target){
        target.takeDamages(strength);
    }

    public void useItem(Item item){
        item.applyEffect();
    }

    public void gainItem(Item item) {inventory.addItem(item);}

    public void giveItem(Character target, Item item){}

}
