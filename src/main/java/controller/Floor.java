package controller;

import model.Move;
import model.Room;

import java.util.ArrayList;

public abstract class Floor {

    protected ArrayList<ArrayList<Room>> roomMatrix;
    protected int playerPositionX;
    protected int playerPositionY;

    public static final int NUMBER_OF_ROOMS = 10;

    public Floor(){
        roomMatrix = new ArrayList<>();
        for(int i = 0; i<NUMBER_OF_ROOMS; i++){
            roomMatrix.add(new ArrayList<>());
        }
        playerPositionX = RandomController.randomPosition(NUMBER_OF_ROOMS);
        playerPositionY = RandomController.randomPosition(NUMBER_OF_ROOMS);
    }

    public abstract void exitRoom(Move move);

    public void ensurePositions(){
        if(playerPositionX + 1 > NUMBER_OF_ROOMS) playerPositionX = 0;
        else if(playerPositionX -1 < 0 ) playerPositionX = NUMBER_OF_ROOMS;
        if(playerPositionY + 1 > NUMBER_OF_ROOMS) playerPositionY = 0;
        else if(playerPositionY -1 < 0 ) playerPositionY = NUMBER_OF_ROOMS;
    }

}
