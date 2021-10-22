package model;

public class BasicFight implements Fight{
    @Override
    public void begin(Character player, Character enemy) {
        while(player.getVitality()>=0 || enemy.getVitality()>=0){
            player.attack(enemy);
            enemy.attack(player);
        }
    }
}
