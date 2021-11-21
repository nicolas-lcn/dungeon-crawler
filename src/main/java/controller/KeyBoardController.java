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
                    controller.goForward();
                    break;
                case "q":
                    controller.handleRotation(Direction.East);
                    break;
                case "d":
                    controller.handleRotation(Direction.West);
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
        switch (event.getCode()) {
            case Z:  controller.goForward(); break;
            case Q:  controller.handleRotation(Direction.West); break;
            case D:  controller.handleRotation(Direction.East); break;
            case I: controller.handleInventory(false);break;
            case K: controller.handleInventory(true);break;
            case ESCAPE: controller.quitGame();break;
            case G: controller.startGame();break;
            case E: controller.handleUseItem(); break;
            case J: controller.handleInventoryNavLeft();
            case L: controller.handleInventoryNavRight();
        }

    }
}
