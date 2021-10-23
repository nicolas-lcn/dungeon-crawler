package model;

import controller.RandomController;

public class Monster extends Character implements Component{

    public Monster(int strength, int vitality, Item item) {
        super(strength, vitality);
        equipItem(item);
    }

    @Override
    public void attack(Character target) {
        target.takeDamages(strength);
    }

    @Override
    public void interact(Character player) {
    //TODO
        System.out.println("Start fight");
    }

    @Override
    public void gainItem(Item item) {}

    @Override
    public void giveItem(Character target, Item item){
        target.gainItem(item);
    }
}
