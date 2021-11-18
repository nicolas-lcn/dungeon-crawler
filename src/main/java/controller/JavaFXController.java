package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Direction;
import model.GameState;

public class JavaFXController implements GameController{

    GameState gameState;
    EventHandler<? super KeyEvent> eventHandler;

    public void setEventHandler(KeyBoardController keyBoardController){
        eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                keyBoardController.handle(event);
            }
        };
    }



    @Override
    public EventHandler<? super KeyEvent> getEventHandler() {
        return eventHandler;
    }

    @Override
    public void initGameState() {
        gameState = GameState.getInstance();
    }

    @Override
    public void handleMovement(Direction direction) {

    }

    @Override
    public void handleInventory(boolean isOpened) {

    }

    @Override
    public void startGame() {
        gameState.resumeGame();
    }

    @Override
    public void quitGame() {
    }

    @Override
    public void handleUseItem() {

    }
}
