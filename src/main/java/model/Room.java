package model;

public abstract class Room {

    private Component component;
    private int nbPortals;

    public Room(Component component, int nbPortals) {
        this.component = component;
        this.nbPortals = nbPortals;
    }

    public abstract void getOut(Move move);

    public void interact(){
        component.interact();
    }

    public void removeComponent(){
        //TODO
    }
}
