package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;

public class Weapon extends Item{

    private int strength;

    public Weapon(String name, int strength) {
        super(name);
        this.strength = strength;
        image = new ImageView(new Image(new File("src/main/java/view/assets/sword.png").toURI().toString()));
        isWearable = true;
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
