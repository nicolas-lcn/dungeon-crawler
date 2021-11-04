package model.states;

import model.Character;
import model.states.Fight;

public class BasicFight extends Fight {
    @Override
    public void begin(Character player, Character enemy) {
        while(player.getVitality()>=0 || enemy.getVitality()>=0){
            player.attack(enemy);
            enemy.attack(player);
        }
    }
}
