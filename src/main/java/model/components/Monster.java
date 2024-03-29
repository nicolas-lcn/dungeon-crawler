package model.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;
import model.Character;

import java.io.File;

public class Monster implements Component {

    private final Character avatar;
    private final Item loot;
    private final GameState gameState;

    public Monster(Character avatar, Item item, GameState gameState) {
        this.avatar = avatar;
        this.loot = item;
        this.gameState = gameState;
    }


    @Override
    public void interact(Player player) {
        gameState.startFight(this.avatar);
        if(this.avatar.getVitality()<=0) player.gainItem(loot);
    }

    public ImageView getImageView() {
        return new ImageView( new Image(new File("src/main/java/view/assets/demon-idle.gif").toURI().toString()));
    }

    @Override
    public String getInteractAlert() {
        return "";
    }

    @Override
    public Character getAvatar() {
        return avatar;
    }
}
