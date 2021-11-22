package model.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;
import model.Character;
import model.components.Component;

import java.io.File;
import java.net.URISyntaxException;

public class Monster implements Component {

    private final Character avatar;
    private Item loot;
    private final FightCreator fightCreator;
    private final GameState gameState;

    public Monster(int strength, int vitality, Item item, FightCreator fightCreator, GameState gameState) {
        avatar = new Character(strength, vitality);
        this.loot = item;
        this.fightCreator = fightCreator;
        this.gameState = gameState;
    }


    @Override
    public void interact(Player player) {
        gameState.startFight();
        Fight fight = fightCreator.createFight(player.getAvatar(), this.avatar);
        fight.fight();
        if(this.avatar.getVitality()<=0) player.gainItem(loot);
        gameState.endFight();
    }

    public ImageView getImageView() {
        return new ImageView( new Image(new File("src/main/java/view/assets/demon-idle.gif").toURI().toString()));
    }

    @Override
    public String getInteractAlert() {
        return "";
    }
}
