package model.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Character;
import model.Player;


import java.io.File;


public class Trap implements Component {
    private final int strength;

    public Trap(int strength) {
        this.strength = strength;
    }

    @Override
    public void interact(Player player) {
        player.getAvatar().takeDamages(strength);
    }

    @Override
    public ImageView getImageView() {
        return new ImageView(new Image(new File("src/main/java/view/assets/bone_shield.png").toURI().toString()));
    }

    @Override
    public String getInteractAlert() {
        return "C'EST UN PIEGE !";
    }

    @Override
    public Character getAvatar() {
        return null;
    }
}
