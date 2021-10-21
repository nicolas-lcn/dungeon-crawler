package model;

public abstract class Character {
    protected int strength;
    protected int vitality;

    public Character(int strength, int vitality) {
        this.strength = strength;
        this.vitality = vitality;
    }

    public int getStrength() {
        return strength;
    }

    public int getVitality() {
        return vitality;
    }

    public abstract void attack();
}
