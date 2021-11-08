package model.components;

import model.Player;
import model.components.Component;

public class Trap implements Component {
    private int strength;

    public Trap(int strength) {
        this.strength = strength;
    }

    @Override
    public void interact(Player player) {
        System.out.println("Piège ! ");
        player.getAvatar().takeDamages(strength);
    }
}
