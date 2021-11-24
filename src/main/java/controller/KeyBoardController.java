package controller;

import javafx.scene.input.KeyEvent;

public class KeyBoardController {

    GameController controller;

    public KeyBoardController(GameController controller) {
        this.controller = controller;
    }

    public void handle(KeyEvent event){
        switch (event.getCode()) {
            case Z:  controller.goForward(); break;
            case Q:  controller.handleLeft(); break;
            case D:  controller.handleRight(); break;
            case I: controller.handleInventory();break;
            case ESCAPE: controller.quitGame();break;
            case G: controller.startGame();break;
            case E: controller.handleUseItem(); break;
            case A: controller.handleAttack(); break;
        }

    }
}
