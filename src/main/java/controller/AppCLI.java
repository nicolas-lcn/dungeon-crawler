package controller;

import model.*;
import model.generators.ItemGenerator;
import model.generators.SimpleComponentGenerator;
import model.generators.SimpleItemGenerator;
import model.places.Dungeon;
import model.places.SimpleDungeon;

import java.util.Scanner;

public class AppCLI {
    public static void main(String[] args) {
        Player player = new Player(5,60);
        SimpleItemGenerator itemGenerator = new SimpleItemGenerator();
        SimpleComponentGenerator componentGenerator = new SimpleComponentGenerator(itemGenerator);
        Dungeon simpleDungeon = new SimpleDungeon(Direction.South, player, componentGenerator);
        Scanner scanner = new Scanner(System.in);
    }
}
