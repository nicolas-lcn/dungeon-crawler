package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Weapon extends Item{

    private int strength;

    public Weapon(String name, int strength) {
        super(name);
        this.strength = strength;
        image = new ImageView(new Image("src/main/java/view/assets/sword.png"));
    }

    @Override
    public void applyEffect(Character target) {
        target.setStrength(target.getStrength() + strength);
    }

    public boolean equals(Object o){
        System.out.println("Weapons");
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
