package model;

public class Player{

    private Inventory inventory;
    private Character avatar;
    private Direction lookingDirection;

    public Player(int strength, int vitality) {
        avatar = new Character(strength, vitality);
        inventory = new Inventory(avatar);
        lookingDirection = Direction.North;

    }

    public Move goNorth() {
        return new Move(Direction.North);
    }
    public Move goSouth() {
        return new Move(Direction.South);
    }

    public Move goEast() {
        return new Move(Direction.East);
    }
    public Move goWest() {
        return new Move(Direction.West);
    }

    public void look(Direction direction){
        this.lookingDirection = direction;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Character getAvatar() {
        return avatar;
    }

    public Direction getLookingDirection() {
        return lookingDirection;
    }

    public void gainItem(Item item) {inventory.addItem(item);}

    public void giveItem(Character target, Item item){}

}
