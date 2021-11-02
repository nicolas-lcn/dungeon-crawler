package model;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item getItem(int index){
        return items.get(index);
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
