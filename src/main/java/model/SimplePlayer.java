package model;

public class SimplePlayer implements Player {

    private final Inventory inventory;
    private final Character avatar;
    private Direction lookingDirection;

    public SimplePlayer(Inventory inventory, Character avatar) {
        this.inventory = inventory;
        this.avatar = avatar;
        lookingDirection = Direction.North;
        this.inventory.setPossessor(avatar);
    }

    @Override
    public Move goNorth() {
        return new SimpleMove(Direction.North);
    }
    @Override
    public Move goSouth() {
        return new SimpleMove(Direction.South);
    }

    @Override
    public Move goEast() {
        return new SimpleMove(Direction.East);
    }
    @Override
    public Move goWest() {
        return new SimpleMove(Direction.West);
    }

    @Override
    public void look(Direction direction){
        this.lookingDirection = direction;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public Character getAvatar() {
        return avatar;
    }

    @Override
    public Direction getLookingDirection() {
        return lookingDirection;
    }

    @Override
    public void gainItem(Item item) {inventory.addItem(item);}

    @Override
    public void giveItem(Character target, Item item){}

}
