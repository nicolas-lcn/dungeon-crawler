package model;

public class Monster extends Character implements Component{

    public Monster(int strength, int vitality) {
        super(strength, vitality);
    }

    @Override
    public void attack(Character target) {
        target.takeDamages(strength);
    }

    @Override
    public void interact() {
    //TODO
    }

}
