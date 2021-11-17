package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private final HashMap<Item, Integer> items;

    private Item equippedItem;

    private final Character possessor;

    public Inventory(Character possessor) {
        items = new HashMap<>();
        equippedItem = null;
        this.possessor = possessor;
    }

    public void addItem(Item item){
        if(items.containsKey(item)) items.put(item, items.get(item)+1);
        else items.put(item, 1);
    }


    public void useItem(Item item){
        if(items.containsKey(item)){
            item.applyEffect(possessor);
        }
    }

    public boolean hasItem(Item item){
        return items.containsKey(item);
    }

    public void removeItem(Item item){
        items.put(item, items.get(item)-1);
    }

    public void equip(Item item){
        equippedItem = item;
        useItem(equippedItem);
    }

    public int getNumber(Item item){
        return items.get(item);
    }

    public String toString(){
        return items.toString();
    }
}
