package controller;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Direction;
import model.GameState;
import model.Move;
import model.Player;
import model.generators.ComponentGenerator;
import model.places.Dungeon;
import model.places.Room;
import model.places.SimpleDungeon;
import view.JavaFXView;
import view.View;

public class JavaFXController implements GameController{


    @Override
    public void handleMovement(Direction direction) {

    }

    @Override
    public void handleInventory(boolean isOpened) {

    }
}
