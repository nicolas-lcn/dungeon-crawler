package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    //private final HashMap<Item, Integer> items;

    private final ArrayList<Item> items;
    private final ArrayList<Integer> itemsQuantity;

    private Item equippedItem;

    private final Character possessor;

    private int selectedItemIndex;

    public Inventory(Character possessor) {
        items = new ArrayList<>();
        equippedItem = null;
        this.possessor = possessor;
        selectedItemIndex = 0;
        itemsQuantity = new ArrayList<>();
    }

    public void addItem(Item item){
        if(items.contains(item)){
            itemsQuantity.set(getIndex(item), getItemQuantity(item)+1);
        }
        else{
            items.add(item);
            itemsQuantity.add(1);
        }
    }

    public int getSize(){
        return items.size();
    }


    public void useItem(Item item){
        if(hasItem(item)){
            if(item.isWearable()) equip(item);
            else {
                item.applyEffect(possessor);
                removeItem(item);
            }
        }
    }

    public boolean hasItem(Item item){
        return items.contains(item);
    }

    public void removeItem(Item item){
        int itemIndex = getIndex(item);
        if(itemsQuantity.get(itemIndex) - 1 > 0){
            itemsQuantity.set(itemIndex, itemsQuantity.get(itemIndex)-1);
        }
        else{
            if(selectedItemIndex >= itemIndex && selectedItemIndex-1>=0){
                selectedItemIndex--;
            }
            items.remove(item);
            itemsQuantity.remove(itemIndex);
        }
    }

    public void equip(Item item){
        equippedItem = item;
        item.applyEffect(possessor);
    }

    public Item getItem(int index){
        if(index < items.size()) return items.get(index);
        else return null;
    }

    public int getIndex(Item item){
        return items.indexOf(item);
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        for(Item item : items){
            string.append(item)
                    .append(" : ")
                    .append(getItemQuantity(item))
                    .append("\n");
        }
        return string.toString();
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        if(selectedItemIndex>items.size()-1) this.selectedItemIndex = 0;
        else if(selectedItemIndex<0) this.selectedItemIndex = items.size()-1;
        else this.selectedItemIndex = selectedItemIndex;
    }

    public Item getEquippedItem() {
        return equippedItem;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Integer> getItemsQuantity() {
        return itemsQuantity;
    }

    public int getItemQuantity(Item item){
        if(hasItem(item)){
            return itemsQuantity.get(items.indexOf(item));
        }
        return -1;
    }
}
