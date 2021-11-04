package model.components;

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
}
