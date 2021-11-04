package model;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;

    private Item equippedItem;

    public Inventory() {
        items = new ArrayList<>();
        equippedItem = null;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item getItem(int index){
        return items.get(index);
    }

    public void useItem(int index){
        this.items.get(index).applyEffect();
    }

    public void useItem(Item item){
        if(items.contains(item)){
            item.applyEffect();
        }
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void removeItem(int index){
        items.remove(index);
    }

    public void equip(Item item){
        equippedItem = item;
        useItem(equippedItem);
    }

    public String toString(){
        StringBuilder inventory = new StringBuilder("[");
        for(Item item : items){
            inventory.append("; ").append(item.getName());
        }
        inventory.append("]");
        return inventory.toString();
    }
}
