package model;

public class Potion extends Item{

    private int vitality;

    public Potion(String name, int vitality) {
        super(name);
        this.vitality = vitality;
    }

    @Override
    public void applyEffect(Character target) {
        target.setVitality(target.getVitality() + vitality);
    }
}
