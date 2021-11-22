package model;

public class Character {
    protected int strength;
    protected int vitality;
    protected boolean turnToAttack;

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

    public void attack(Character target){
        target.takeDamages(this.strength);
    }

    public void takeDamages(int damages){
        vitality -= damages;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public boolean isTurnToAttack() {
        return turnToAttack;
    }

    public void setTurnToAttack(boolean turnToAttack) {
        this.turnToAttack = turnToAttack;
    }
}
