package controller;

import model.*;
import model.generators.ItemGenerator;
import model.generators.SimpleComponentGenerator;
import model.generators.SimpleItemGenerator;
import model.places.Dungeon;
import model.places.SimpleDungeon;
import model.states.InGame;

import java.util.Scanner;

public class AppCLI {
    public static void main(String[] args) {
        Player player = new Player(50,10000);
        SimpleItemGenerator itemGenerator = new SimpleItemGenerator();
        GameState gameState = new GameState();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while(! line.equals("G")){
            line = scanner.nextLine();
        }
        gameState.resumeGame();
        SimpleComponentGenerator componentGenerator = new SimpleComponentGenerator(itemGenerator, gameState);
        Dungeon simpleDungeon = new SimpleDungeon(Direction.South, player, componentGenerator);
        CLIController cliController = new CLIController(player, simpleDungeon);
        while(player.getAvatar().getVitality()>0){
            System.out.println(gameState.state);
            //String command = scanner.nextLine();
            //if(command.equals("Q")) break;
            //cliController.handleCommand(command);
            cliController.handleCommand("M");
            cliController.handleCommand("N");
            cliController.handleCommand("N");
            cliController.handleCommand("E");
            cliController.handleCommand("E");
            cliController.handleCommand("W");
            cliController.handleCommand("W");
            cliController.handleCommand("S");
            cliController.handleCommand("S");
        }
        System.out.println(player.getInventory() + " " + player.getAvatar().getVitality());

    }
}
