package model.components;

import model.Character;
import model.Item;
import model.Player;
import model.components.Component;

public class Monster implements Component {

    private Character avatar;
    private Item loot;

    public Monster(int strength, int vitality, Item item) {
        avatar = new Character(strength, vitality);
        this.loot = item;
    }

    @Override
    public void interact(Player player) {
    //TODO
        System.out.println("Start fight");
    }

}
