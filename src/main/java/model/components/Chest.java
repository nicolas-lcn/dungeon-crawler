package model.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Character;
import model.Item;
import model.Player;

import java.io.File;

public class Chest implements Component {
    private final Item item;

    public Chest(Item item) {
        this.item = item;
    }

    @Override
    public void interact(Player player) {
        player.gainItem(item);
    }

    @Override
    public ImageView getImageView() {
        return  new ImageView(new Image(new File("src/main/java/view/assets/chest10_32x32.gif").toURI().toString()));
    }

    @Override
    public String getInteractAlert() {
        return "Vous trouvez :\n " + item.getName() + " !";
    }

    @Override
    public Character getAvatar() {
        return null;
    }
}
