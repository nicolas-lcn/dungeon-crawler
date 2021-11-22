package model;

public class BasicFightCreator extends FightCreator {

    @Override
    public Fight createFight(Character player, Character enemy) {
        return new BasicFight(player, enemy);
    }
}
