package view;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Direction;
import model.GameState;

public class GameView implements View{

    public AnchorPane GameVisualisation;
    public ImageView RoomViewer;
    public AnchorPane ComponentViewer;
    public ImageView ComponentImage;
    public ImageView MainUI;
    public AnchorPane WeaponAnchor;
    public ImageView WeaponImage;
    public AnchorPane PotionAnchor;
    public ImageView PotionImage;
    public ProgressBar HPBar;
    public TextArea GamestateViewer;
    public TextField NumberOfWeapon;
    public TextField NumberOfPotions;
    public TextField StrengthViewer;
    public Button East;
    public Button West;
    public Button South;
    public Button North;
    public MenuItem QuitButton;
    public final GameState gameState = GameState.getInstance();


    @Override
    public void startGame() {

    }

    @Override
    public void gameOver() {

    }

    @Override
    public void titleScreen() {

    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public void beginFight() {

    }

    @Override
    public void stopFight() {
    }

    @Override
    public void quitGame() {

    }

    @Override
    public void setGameState() {

    }

    @Override
    public void handleMovement(Direction oldDirection, Direction newDirection) {
        switch(oldDirection){
            case South:
                switch(newDirection){
                    case West:turnRight();break;
                    case East:turnLeft();break;
                    case North:turnRight();turnRight();break;
                }
                break;
            case West:
                switch(newDirection){
                    case North:turnRight();break;
                    case South:turnLeft();break;
                    case East:turnRight();turnRight();break;
                }
                break;
            case East:
                switch(newDirection){
                    case South:turnRight();break;
                    case North:turnLeft();break;
                    case West:turnRight();turnRight();break;
                }
                break;
            case North:
                switch(newDirection){
                    case East:turnRight();break;
                    case West:turnLeft();break;
                    case South:turnRight();turnRight();break;
                }
                break;
        }
    }

    public void turnRight(){
        RoomViewer.setLayoutX(-1536);
        System.out.println("turning");
        RoomViewer.setLayoutX(0);
        System.out.println("turning");
        RoomViewer.setLayoutX(-768);
    }

    public void turnLeft(){
        RoomViewer.setLayoutX(0);
        RoomViewer.setLayoutX(-1536);
        RoomViewer.setLayoutX(-768);
    }
}
