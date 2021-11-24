package model;

import java.util.ArrayList;

public interface Inventory {
    void addItem(Item item);

    int getSize();

    void useItem(Item item);

    boolean hasItem(Item item);

    void removeItem(Item item);

    void equip(Item item);

    Item getItem(int index);

    int getIndex(Item item);

    String toString();

    int getSelectedItemIndex();

    void setSelectedItemIndex(int selectedItemIndex);

    Item getEquippedItem();

    boolean isEmpty();

    ArrayList<Item> getItems();

    ArrayList<Integer> getItemsQuantity();

    int getItemQuantity(Item item);

    void setPossessor(Character character);
}
