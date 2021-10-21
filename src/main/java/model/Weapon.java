package model;

public class Weapon extends Item{

    private int strength;

    public Weapon(String name, int strength) {
        super(name);
        this.strength = strength;
    }

    @Override
    public void applyEffect() {
        //TODO
    }
}
