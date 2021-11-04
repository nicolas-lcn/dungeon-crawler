package controller;

import model.*;
import model.places.Dungeon;
import model.places.SimpleDungeon;

import java.util.Scanner;

public class AppCLI {
    public static void main(String[] args) {
        Player player = new Player(5,6);
        Dungeon simpleDungeon = new SimpleDungeon(Direction.South, player);
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<10; i++){
            System.out.println("Player vitality : " + player.getAvatar().getVitality());
            System.out.println("Player inventory : " + player.getInventory().toString());
            System.out.println(simpleDungeon.getCurrentFloor().getCurrentRoom().possibleDirections());
            int direction = scanner.nextInt();
            Move playerMove;
            if(Direction.values()[direction].equals(Direction.North)) playerMove = player.goNorth();
            else if(Direction.values()[direction].equals(Direction.South)) playerMove = player.goSouth();
            else if(Direction.values()[direction].equals(Direction.East)) playerMove = player.goEast();
            else playerMove = player.goWest();
            MoveController.applyMove(playerMove, simpleDungeon.getCurrentFloor().getCurrentRoom(), player, simpleDungeon.getCurrentFloor());
        }
    }
}
