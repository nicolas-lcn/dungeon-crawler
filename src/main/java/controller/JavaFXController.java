package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Direction;
import model.GameState;
import model.Move;
import model.Player;
import model.places.Dungeon;
import model.places.Room;
import view.JavaFXView;
import view.View;

public class JavaFXController {
    EventHandler<? super KeyEvent> eventHandler;
    GameState gameState;
    Player player;
    Dungeon dungeon;
    View view;

    public JavaFXController( Player player, Dungeon dungeon, View view) {
        this.gameState = GameState.getInstance();
        this.player = player;
        this.dungeon = dungeon;
        this.view = view;
    }

    public void handleMovement(Direction direction){
        Room room = dungeon.getCurrentFloor().getCurrentRoom();
        if(player.getLookingDirection().equals(direction)){
            Move move;
            switch (direction){
                case North:
                    move = player.goNorth();
                    break;
                case East:
                    move = player.goEast();
                    break;
                case West:
                    move = player.goWest();
                    break;
                default:
                    move = player.goSouth();
            }
            MoveController.applyMove(move, room , player, dungeon.getCurrentFloor());
            view.handleMove(direction);
        }
        else{
            player.look(direction);
            view.handleLook(direction);
        }
    }
}
