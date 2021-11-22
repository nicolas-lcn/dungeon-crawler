package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;

public class Potion extends Item{

    private final int vitality;

    public Potion(String name, int vitality) {
        super(name);
        this.vitality = vitality;
        image = new ImageView(new Image(new File("src/main/java/view/assets/potionGreen.png").toURI().toString()));
        isWearable = false;
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
