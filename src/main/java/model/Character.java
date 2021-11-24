package model;

public interface Character {
    int getStrength();

    int getVitality();

    void attack(Character target);

    void takeDamages(int damages);

    void setStrength(int strength);

    void setVitality(int vitality);

    boolean isTurnToAttack();

    void setTurnToAttack(boolean turnToAttack);

    int getInitialVitality();
}
