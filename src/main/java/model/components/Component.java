package model.components;

import javafx.scene.image.ImageView;
import model.Player;

public interface Component {
    public void interact(Player player);
    public ImageView getImageView();
    public String getInteractAlert();
}
