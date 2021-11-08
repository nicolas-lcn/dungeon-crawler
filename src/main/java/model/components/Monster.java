package model.components;

import model.*;
import model.Character;
import model.components.Component;

public class Monster implements Component {

    private final Character avatar;
    private Item loot;
    private final FightCreator fightCreator;
    private final GameState gameState;

    public Monster(int strength, int vitality, Item item, FightCreator fightCreator, GameState gameState) {
        avatar = new Character(strength, vitality);
        this.loot = item;
        this.fightCreator = fightCreator;
        this.gameState = gameState;
    }


    @Override
    public void interact(Player player) {
        gameState.startFight();
        Fight fight = fightCreator.createFight(player.getAvatar(), this.avatar);
        fight.fight();
        if(this.avatar.getVitality()<=0) player.gainItem(loot);
        gameState.endFight();
    }

}
