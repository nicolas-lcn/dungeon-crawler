package model.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Player;
import model.components.Component;

import java.io.File;
import java.net.URISyntaxException;

public class Trap implements Component {
    private int strength;

    public Trap(int strength) {
        this.strength = strength;
    }

    @Override
    public void interact(Player player) {
        System.out.println("Piège ! ");
        player.getAvatar().takeDamages(strength);
    }

    @Override
    public ImageView getImageView() {
        return new ImageView(new Image(new File("src/main/java/view/assets/bone_shield.png").toURI().toString()));
    }
}
