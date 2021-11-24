package model;

public class SimpleCharacter implements Character {
    protected int strength;
    protected int vitality;
    protected boolean turnToAttack;
    protected final int initialVitality;

    public SimpleCharacter(int strength, int vitality) {
        this.strength = strength;
        this.vitality = vitality;
        initialVitality = vitality;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getVitality() {
        return vitality;
    }

    @Override
    public void attack(Character target){
        target.takeDamages(this.strength);
    }

    @Override
    public void takeDamages(int damages){
        vitality -= damages;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    @Override
    public boolean isTurnToAttack() {
        return turnToAttack;
    }

    @Override
    public void setTurnToAttack(boolean turnToAttack) {
        this.turnToAttack = turnToAttack;
    }

    @Override
    public int getInitialVitality() {
        return initialVitality;
    }
}
