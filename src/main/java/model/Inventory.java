package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private final HashMap<Item, Integer> items;

    private Item equippedItem;

    private final Character possessor;

    private int selectedItemIndex;

    public Inventory(Character possessor) {
        items = new HashMap<>();
        equippedItem = null;
        this.possessor = possessor;
        selectedItemIndex = 0;
    }

    public void addItem(Item item){
        if(items.containsKey(item)) items.put(item, items.get(item)+1);
        else items.put(item, 1);
    }


    public void useItem(Item item){
        if(items.containsKey(item)){
            if(item.isWearable) equip(item);
            else item.applyEffect(possessor);
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
        item.applyEffect(possessor);
    }

    public Item getItem(int index){
        int i = 0;
        for(Item item : items.keySet()){
            if(i == index) return item;
            i++;
        }
        return null;
    }

    public int getNumber(Item item){
        return items.get(item);
    }

    public String toString(){
        return items.toString();
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        if(selectedItemIndex>items.keySet().size()) this.selectedItemIndex = 0;
        else if(selectedItemIndex<0) this.selectedItemIndex = items.keySet().size()-1;
        else this.selectedItemIndex = selectedItemIndex;
    }

    public Item getEquippedItem() {
        return equippedItem;
    }
}
