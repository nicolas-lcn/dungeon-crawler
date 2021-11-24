package controller;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.*;
import model.Character;
import model.components.Component;
import model.generators.ComponentGenerator;
import model.places.Dungeon;
import model.places.SimpleDungeon;
import view.View;

import java.util.ArrayList;

public class JavaFXController implements GameController{

    GameState gameState;
    EventHandler<? super KeyEvent> eventHandler;
    View view;
    Player player;
    Dungeon dungeon;
    ComponentGenerator componentGenerator;
    boolean isInventoryOpened;
    FightCreator fightCreator;
    Fight fight;
    boolean hasShownComponent;
    boolean isGameStarted;

    public JavaFXController(Player player){
        this.player = player;
        fightCreator = new BasicFightCreator();
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
    public void handleInventory() {
        if(isInventoryOpened){
            isInventoryOpened = false;
            gameState.closeInventory();
            view.closeInventory();
        }
        else{
            if( ! player.getInventory().isEmpty()) {
                isInventoryOpened = true;
                view.openInventory();
                gameState.openInventory();
            }
        }
    }

    @Override
    public void startGame() {
        if(!isGameStarted) {
            hasShownComponent = false;
            gameState.resumeGame();
            this.setDungeon(new SimpleDungeon(Direction.South, player, componentGenerator));
            handleDoorDisplay();
            isGameStarted = true;
            handleHPBarDisplay();
        }

    }

    @Override
    public void quitGame() {
        Platform.exit();
    }

    @Override
    public void handleUseItem() {
        Inventory inventory = player.getInventory();
        int initSelected = inventory.getSelectedItemIndex();
        gameState.handleUseItem(inventory, inventory.getItem(inventory.getSelectedItemIndex()));
        if(inventory.getSelectedItemIndex()<initSelected) view.setItemImage(null, initSelected);
        handleAllPlayerPropertiesDisplay();
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void handleRotation(Direction direction) {
        int playerLookingDirection = Direction.valueOf(player.getLookingDirection().toString()).ordinal();
        switch(direction){
            case East:
                if(playerLookingDirection+1 > Direction.values().length-1) playerLookingDirection = 0;
                else playerLookingDirection++;
                view.turnRight();
                break;
            case West:
                if(playerLookingDirection-1 < 0) playerLookingDirection = Direction.values().length-1;
                else playerLookingDirection--;
                view.turnLeft();
                break;

        }
        player.look(Direction.values()[playerLookingDirection]);
        handleDoorDisplay();

    }

    @Override
    public void goForward() {
        int playerPosition = dungeon.getCurrentFloor().getPlayerPositionX();
        MoveController.applyMove(new Move(player.getLookingDirection()), dungeon, player);
        int newPlayerPosition = dungeon.getCurrentFloor().getPlayerPositionX();
        hasShownComponent = playerPosition==newPlayerPosition;
        handleComponentDisplay();
        handleDoorDisplay();
        handleAllPlayerPropertiesDisplay();
        if(player.getAvatar().getVitality()<=0) gameState.gameOver();
    }

    @Override
    public void handleInventoryNavRight() {
        Inventory inventory = player.getInventory();
        view.inventoryNavRight();
        inventory.setSelectedItemIndex(inventory.getSelectedItemIndex()+1);
    }

    @Override
    public void handleInventoryNavLeft() {
        Inventory inventory = player.getInventory();
        view.inventoryNavLeft();
        inventory.setSelectedItemIndex(inventory.getSelectedItemIndex()-1);
    }

    @Override
    public void handleRight() {
        if(isInventoryOpened){
            if(player.getInventory().getSize()>1) handleInventoryNavRight();
        }
        else handleRotation(Direction.East);
    }

    @Override
    public void handleLeft() {
        if(isInventoryOpened){
            if(player.getInventory().getSize()>1) handleInventoryNavLeft();
        }
        else handleRotation(Direction.West);
    }

    @Override
    public void handleFight(boolean hasStarted, Character enemyFighter) {
        if(hasStarted){
            if(player.getAvatar().getVitality()<=0){
                gameState.gameOver();
            }else gameState.resumeGame();
        }
        else{
            fight = fightCreator.createFight(player.getAvatar(), enemyFighter);

        }

    }

    @Override
    public void handleAttack() {
        view.playerAttack();
        player.getAvatar().setTurnToAttack(true);
        boolean isFightOver = fight.fight();
        if(isFightOver) gameState.endFight();
        else{
            Component enemy = dungeon.getCurrentFloor().getCurrentRoom().getComponent();
            handleHPBarDisplay();
            view.updateMonsterHPBar(
                    enemy.getAvatar().getVitality(),
                    enemy.getAvatar().getInitialVitality()
            );
        }
    }

    @Override
    public void handleAllPlayerPropertiesDisplay() {
        handleHPBarDisplay();
        handleStrengthDisplay();
        handleInventoryDisplay();
    }

    public void handleHPBarDisplay() {
        view.updateHPBar(
                player.getAvatar().getVitality(),
                player.getAvatar().getInitialVitality()
        );
    }

    public void handleDoorDisplay(){
        view.waitToShow(500, dungeon.getCurrentFloor().getCurrentRoom().possibleDirections().contains(player.getLookingDirection()));
    }

    public void handleStrengthDisplay(){
        view.setStrengthViewer(player.getAvatar().getStrength());
    }

    public void handleComponentDisplay(){
        if( ! hasShownComponent) {
            view.setRoomComponentImage(dungeon.getCurrentFloor().getCurrentRoom().getComponent().getImageView());
            System.out.println(dungeon.getCurrentFloor().getCurrentRoom().getComponent().getInteractAlert());
            view.setUIText(dungeon.getCurrentFloor().getCurrentRoom().getComponent().getInteractAlert());
            view.waitToClear(1000);
        }
    }

    public void handleInventoryDisplay(){

        view.resetItemImages();

        Inventory inventory = player.getInventory();

        if(inventory.isEmpty()) {
            view.hideInventory();
        }else{
            view.setNumberOfItems(inventory.getItemsQuantity());
        }

        for(Item item : inventory.getItems()){

            view.setItemImage(item.getImage(), inventory.getIndex(item));

            if(item.isWearable() && item.equals(inventory.getEquippedItem()))
                view.setEquippedItemVisible(inventory.getIndex(item));

            if(item.isStackable())
                view.setNumberVisible(inventory.getIndex(item));
        }
    }

}
