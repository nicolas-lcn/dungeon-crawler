package model;

public class BasicFight extends Fight {

    Character player;
    Character enemy;

    public BasicFight(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void fight() {
        while(player.getVitality()>=0 || enemy.getVitality()>=0){
            player.attack(enemy);
            enemy.attack(player);
        }
    }
}
