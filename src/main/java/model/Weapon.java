package model;

public class Weapon extends Item{

    private int strength;

    public Weapon(String name, int strength) {
        super(name);
        this.strength = strength;
    }

    @Override
    public void applyEffect(Character target) {
        target.setStrength(target.getStrength() + strength);
    }

    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof Weapon)) {
            return false;
        }

        Weapon p = (Weapon) o;

        return p.getName().equals(this.getName()) && p.strength == this.strength;
    }
}
