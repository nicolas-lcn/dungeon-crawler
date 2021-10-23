package model;

public abstract class Character {
    protected int strength;
    protected int vitality;
    protected Inventory inventory;
    protected Item equippedItem;

    public Character(int strength, int vitality) {
        this.strength = strength;
        this.vitality = vitality;
        inventory = new Inventory();
        equippedItem = null;
    }

    public int getStrength() {
        return strength;
    }

    public int getVitality() {
        return vitality;
    }

    public abstract void attack(Character target);

    public void takeDamages(int damages){
        vitality -= damages;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void equipItem(Item item){
        this.equippedItem = item;
        equippedItem.applyEffect();
    }

    public abstract void gainItem(Item item);

    public abstract void giveItem(Character target, Item item);
}
