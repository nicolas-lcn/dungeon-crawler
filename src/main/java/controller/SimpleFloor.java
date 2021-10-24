package controller;

import model.Direction;
import model.Move;
import model.SimpleRoom;

public class SimpleFloor extends Floor{

    public SimpleFloor(){
        super();
        addRoom(Direction.South);
    }

    @Override
    public void exitRoom(Move move) {
        switch(move.getDirection()){
            case North:
                ensurePositions();
                playerPositionX += 1;
            case South:
                ensurePositions();
                playerPositionX -= 1;
            case East:
                ensurePositions();
                playerPositionY += 1;
            case West:
                ensurePositions();
                playerPositionY -= 1;
        }
        addRoom(move.getOpposedDirection());
    }

    private void addRoom(Direction previousDirection){
        roomMatrix.get(playerPositionX)
                  .add(playerPositionY, new SimpleRoom(RandomController.randomComponent(),
                                                       RandomController.randomPortalNumber(),
                                                       previousDirection));
    }
}
