package model.generators;

import controller.RandomController;
import model.Item;
import model.Potion;
import model.Weapon;

import java.util.ArrayList;

public class SimpleItemGenerator extends ItemGenerator{

    public ArrayList<Item> possibleItems;

    public SimpleItemGenerator(){
        possibleItems = new ArrayList<>();
        possibleItems.add(new Weapon("Epee du Heros", 2));
        possibleItems.add(new Potion("Potion de Vitalite", 4));
    }

    @Override
    public Item generate() {
        return possibleItems.get(RandomController.randomInt(possibleItems.size()));
    }

    @Override
    public void reset() {
        possibleItems = new ArrayList<>();
        possibleItems.add(new Weapon("Epee du Heros", 2));
        possibleItems.add(new Potion("Potion de Vitalite", 4));
    }
}
