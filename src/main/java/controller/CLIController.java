package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Direction;
import model.GameState;
import model.Move;
import model.Player;
import model.places.Dungeon;
import model.places.Room;

public class CLIController implements GameController{
    GameState gameState;
    Player player;
    Dungeon dungeon;

    public CLIController(Player player, Dungeon dungeon) {
        this.gameState = GameState.getInstance();
        this.player = player;
        this.dungeon = dungeon;
    }

    public void handleCommand(String command){
        switch(command.charAt(0)){
            case 'N':
                handleMovement(Direction.North);
                break;
            case 'S':
                handleMovement(Direction.South);
                break;
            case 'E':
                handleMovement(Direction.East);
                break;
            case 'W':
                handleMovement(Direction.West);
                break;
            case 'I':
                handleInventory(false);
                break;
            case 'K':
                handleInventory(true);
                break;
            case 'G':
                gameState.resumeGame();
                break;
            case 'M':
                System.out.println("PV : " + player.getAvatar().getVitality());
                break;
            default :
                System.out.println("En attente d'une commande valide");
                break;
        }
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

    public void handleInventory(boolean isOpened){
        if(isOpened) gameState.closeInventory();
        else {
            gameState.openInventory();
            System.out.println(player.getInventory().toString());
        }
    }

    @Override
    public void startGame() {

    }

    @Override
    public void quitGame() {

    }

    @Override
    public void handleUseItem() {

    }

    @Override
    public void setEventHandler(KeyBoardController keyBoardController) {

    }

    @Override
    public EventHandler<? super KeyEvent> getEventHandler() {
        return null;
    }

    @Override
    public void initGameState() {

    }

}
