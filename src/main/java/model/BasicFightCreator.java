package model;

public class BasicFightCreator extends FightCreator {

    public BasicFightCreator(GameState gameState){
        this.gameState = gameState;
    }

    @Override
    public Fight createFight(Character player, Character enemy) {
        return new BasicFight(player, enemy);
    }
}
