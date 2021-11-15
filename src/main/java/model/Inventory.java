package model;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;

    private Item equippedItem;

    private Character possessor;

    public Inventory(Character possessor) {
        items = new ArrayList<>();
        equippedItem = null;
        this.possessor = possessor;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item getItem(int index){
        return items.get(index);
    }

    public void useItem(int index){
        this.items.get(index).applyEffect(possessor);
    }

    public void useItem(Item item){
        if(items.contains(item)){
            item.applyEffect(possessor);
        }
    }

    public boolean hasItem(Item item){
        return items.contains(item);
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
