package model.components;

import javafx.scene.image.ImageView;
import model.Character;
import model.Item;
import model.Player;
import model.components.Component;

public class Chest implements Component {
    private Item item;

    public Chest(Item item) {
        this.item = item;
    }

    @Override
    public void interact(Player player) {
        player.gainItem(item);
    }

    @Override
    public ImageView getImageView() {
        return item.getImage();
    }

    @Override
    public String getInteractAlert() {
        return "You found : " + item.getName() + " !";
    }

    @Override
    public Character getAvatar() {
        return null;
    }
}
