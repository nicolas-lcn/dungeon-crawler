package controller;

import javafx.scene.input.KeyEvent;
import model.Direction;
import model.Player;

import java.util.Scanner;

public class KeyBoardController {

    GameController controller;

    public KeyBoardController(GameController controller) {
        this.controller = controller;
    }

    public void read() {
        Player player = new Player(6,5);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            switch (scanner.next()) {
                case "z":
                    controller.handleMovement(Direction.North);
                    break;
                case "s":
                    controller.handleMovement(Direction.South);
                    break;
                case "q":
                    controller.handleMovement(Direction.East);
                    break;
                case "d":
                    controller.handleMovement(Direction.West);
                    break;
                case "i":
                    controller.handleInventory(false);
                    break;
                case "k":
                    controller.handleInventory(true);
                    break;
            }

        }
    }

    public void handle(KeyEvent event){
        System.out.println(event.getCode());
        switch (event.getCode()) {
            case UP:    controller.handleMovement(Direction.North); break;
            case DOWN:  controller.handleMovement(Direction.South); break;
            case LEFT:  controller.handleMovement(Direction.East); break;
            case RIGHT: controller.handleMovement(Direction.West); break;
            case I: controller.handleInventory(false);break;
            case K: controller.handleInventory(true);break;
            case ESCAPE: controller.quitGame();break;
            case G: controller.startGame();break;
            case E: controller.handleUseItem(); break;
        }

    }
}
