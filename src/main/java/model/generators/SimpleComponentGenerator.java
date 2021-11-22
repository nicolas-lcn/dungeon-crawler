package model.generators;

import controller.RandomController;
import model.BasicFightCreator;
import model.GameState;
import model.Weapon;
import model.components.Chest;
import model.components.Component;
import model.components.Monster;
import model.components.Trap;

import java.util.ArrayList;

public class SimpleComponentGenerator extends ComponentGenerator{

    public ArrayList<Component> possibleComponents;
    ItemGenerator itemGenerator;
    GameState gameState;

    public SimpleComponentGenerator(ItemGenerator itemGenerator, GameState gameState){
        this.itemGenerator = itemGenerator;
        this.gameState = gameState;
        possibleComponents = new ArrayList<>();
        possibleComponents.add(new Monster(5,30,itemGenerator.generate(), gameState));
        possibleComponents.add(new Chest(itemGenerator.generate()));
        possibleComponents.add(new Trap(4));
    }

    @Override
    public Component generate() {
        int chosenComponentIndex = RandomController.randomInt(possibleComponents.size());
        Component chosen = possibleComponents.get(chosenComponentIndex);
        reset();
        return chosen;
    }

    @Override
    public void reset() {
        possibleComponents = new ArrayList<>();
        possibleComponents.add(new Monster(5,30,itemGenerator.generate(), gameState));
        possibleComponents.add(new Chest(itemGenerator.generate()));
        possibleComponents.add(new Trap(4));
    }
}
