package model.components;

import javafx.scene.image.ImageView;
import model.Character;
import model.Player;

public interface Component {
    public void interact(Player player);
    public ImageView getImageView();
    public String getInteractAlert();
    public Character getAvatar();
}
