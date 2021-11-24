package model;

public interface Player {
    Move goNorth();

    Move goSouth();

    Move goEast();

    Move goWest();

    void look(Direction direction);

    Inventory getInventory();

    Character getAvatar();

    Direction getLookingDirection();

    void gainItem(Item item);

    void giveItem(Character target, Item item);
}
