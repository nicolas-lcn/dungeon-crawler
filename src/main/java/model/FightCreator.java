package model;

public abstract class FightCreator {
    GameState gameState;

    public abstract Fight createFight(Character player, Character enemy);
}
