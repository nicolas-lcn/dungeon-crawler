package model;

import view.ConsoleView;
import view.View;

public class Player extends Character {
    private Inventory inventory;
    private Item equippedItem;

    public Player(int strength, int vitality) {
        super(strength, vitality);
        inventory = new Inventory();
        equippedItem = null;
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

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void attack(){
        //TODO
    }

    public void equipItem(Item item){
        this.equippedItem = item;
    }

    public void useItem(Item item){
        item.applyEffect();
    }

    public void takeDamages(int damages){
        vitality -= damages;
    }

}
