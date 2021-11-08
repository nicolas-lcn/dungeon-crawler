package model.components;

import model.*;
import model.Character;
import model.components.Component;

public class Monster implements Component {

    private final Character avatar;
    private Item loot;
    private final FightCreator fightCreator;

    public Monster(int strength, int vitality, Item item, FightCreator fightCreator) {
        avatar = new Character(strength, vitality);
        this.loot = item;
        this.fightCreator = fightCreator;
    }


    @Override
    public void interact(Player player) {
        Fight fight = fightCreator.createFight(player.getAvatar(), this.avatar);
        fight.fight();
    }

}
