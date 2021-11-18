package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Potion extends Item{

    private final int vitality;

    public Potion(String name, int vitality) {
        super(name);
        this.vitality = vitality;
        image = new ImageView(new Image("src/main/java/view/assets/potionGreen.png"));
    }

    @Override
    public void applyEffect(Character target) {
        target.setVitality(target.getVitality() + vitality);
    }

    public boolean equals(Object o){
        System.out.println("Ptions");
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
