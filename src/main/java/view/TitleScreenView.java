package view;

import javafx.scene.image.ImageView;

public class TitleScreenView implements View{
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
        System.out.println("called on " + this);
    }

    @Override
    public void quitGame() {

    }

    @Override
    public void setGameState() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void setRoomComponentImage(ImageView image) {

    }

    @Override
    public void setUIText(String text) {

    }

}
