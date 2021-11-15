package controller;

import model.Player;

import java.util.Scanner;

public class KeyBoardController {

    public void read() {
        Player player = new Player(6,5);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("enter your move");
            switch (scanner.next()) {

                case "z":
                    player.goNorth();
                    break;
            }

        }
    }
}
