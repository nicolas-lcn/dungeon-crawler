package controller;

import model.*;
import model.Character;

import java.util.Scanner;

public class AppCLI {
    public static void main(String[] args) {
        Player player = new Player(5,6);
        Dungeon simpleDungeon = new SimpleDungeon(Direction.South, player);
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<10; i++){
            System.out.println("Player vitality : " + player.getVitality());
            System.out.println("Player inventory : " + player.getInventory().toString());
            System.out.println(simpleDungeon.getCurrentFloor().getCurrentRoom().possibleDirections());
            int direction = scanner.nextInt();
            MoveController.applyMove(new Move(Direction.values()[direction]), simpleDungeon.getCurrentFloor().getCurrentRoom(), player, simpleDungeon.getCurrentFloor());
        }
    }
}
