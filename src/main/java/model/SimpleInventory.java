package model;

import java.util.ArrayList;

public class SimpleInventory implements Inventory {

    //private final HashMap<Item, Integer> items;

    private final ArrayList<Item> items;
    private final ArrayList<Integer> itemsQuantity;

    private Item equippedItem;

    private Character possessor;

    private int selectedItemIndex;

    public SimpleInventory() {
        items = new ArrayList<>();
        equippedItem = null;
        selectedItemIndex = 0;
        itemsQuantity = new ArrayList<>();
    }

    @Override
    public void addItem(Item item){
        if(items.contains(item)){
            itemsQuantity.set(getIndex(item), getItemQuantity(item)+1);
        }
        else{
            items.add(item);
            itemsQuantity.add(1);
        }
    }

    @Override
    public int getSize(){
        return items.size();
    }


    @Override
    public void useItem(Item item){
        if(hasItem(item)){
            if(item.isWearable()) equip(item);
            else {
                item.applyEffect(possessor);
                removeItem(item);
            }
        }
    }

    @Override
    public boolean hasItem(Item item){
        return items.contains(item);
    }

    @Override
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

    @Override
    public void equip(Item item){
        equippedItem = item;
        item.applyEffect(possessor);
    }

    @Override
    public Item getItem(int index){
        if(index < items.size()) return items.get(index);
        else return null;
    }

    @Override
    public int getIndex(Item item){
        return items.indexOf(item);
    }

    @Override
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

    @Override
    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    @Override
    public void setSelectedItemIndex(int selectedItemIndex) {
        if(selectedItemIndex>items.size()-1) this.selectedItemIndex = 0;
        else if(selectedItemIndex<0) this.selectedItemIndex = items.size()-1;
        else this.selectedItemIndex = selectedItemIndex;
    }

    @Override
    public Item getEquippedItem() {
        return equippedItem;
    }

    @Override
    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public ArrayList<Integer> getItemsQuantity() {
        return itemsQuantity;
    }

    @Override
    public int getItemQuantity(Item item){
        if(hasItem(item)){
            return itemsQuantity.get(items.indexOf(item));
        }
        return -1;
    }

    @Override
    public void setPossessor(Character character) {
        this.possessor = character;
    }
}
