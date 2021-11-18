package controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Direction;
import model.GameState;
import model.Move;
import model.Player;
import model.generators.ComponentGenerator;
import model.places.Dungeon;
import model.places.Room;
import model.places.SimpleDungeon;
import view.View;

public class JavaFXController implements GameController{

    GameState gameState;
    EventHandler<? super KeyEvent> eventHandler;
    View view;
    Player player;
    Dungeon dungeon;
    ComponentGenerator componentGenerator;

    public JavaFXController(Player player){
        this.player = player;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public void setComponentGenerator(ComponentGenerator componentGenerator) {
        this.componentGenerator = componentGenerator;
    }

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
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void handleMovement(Direction direction) {
        view.handleMovement(player.getLookingDirection(), direction);
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
            MoveController.applyMove(move,dungeon, player);
        }
        else{
            player.look(direction);
            if(room.possibleDirections().contains(direction)) {
                System.out.println("Un portail vers une autre dimension se trouve devant vous...");
            } else {
                System.out.println("Devant vous ne se trouve qu'un mur de briques...");
            }
        }
    }

    @Override
    public void handleInventory(boolean isOpened) {
    }

    @Override
    public void startGame() {
        gameState.resumeGame();
        this.setDungeon(new SimpleDungeon(Direction.South, player, componentGenerator));
    }

    @Override
    public void quitGame() {
        Platform.exit();
    }

    @Override
    public void handleUseItem() {

    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public Direction getProperDirection(){
        int playerLookingDirection = Direction.valueOf(player.getLookingDirection().toString()).ordinal();
        return null;
    }
}
