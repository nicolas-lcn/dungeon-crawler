package model;

public class BasicFight extends Fight {

    Character player;
    Character enemy;

    public BasicFight(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public boolean fight() {
        if(player.getVitality()>=0 && enemy.getVitality()>=0){
            if(player.isTurnToAttack()){
                player.attack(enemy);
                player.setTurnToAttack(false);
                enemy.setTurnToAttack(true);
            }
            if(enemy.isTurnToAttack()) enemy.attack(player);
            return false;
        }
        return true;
    }
}
