package model;

public class Chest implements Component{
    private Item item;

    public Chest(Item item) {
        this.item = item;
    }

    @Override
    public void interact(Character player) {
        player.gainItem(item);
    }
}
