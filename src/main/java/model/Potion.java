package model;

public class Potion extends Item{

    private final int vitality;

    public Potion(String name, int vitality) {
        super(name);
        this.vitality = vitality;
    }

    @Override
    public void applyEffect(Character target) {
        target.setVitality(target.getVitality() + vitality);
    }

    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof Potion)) {
            return false;
        }

        Potion p = (Potion) o;

        return p.getName().equals(this.getName()) && vitality == p.vitality;
    }
}
