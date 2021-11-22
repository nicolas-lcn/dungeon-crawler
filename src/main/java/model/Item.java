package model;

import javafx.scene.image.ImageView;

public abstract class Item{
    private String name;
    ImageView image;
    boolean isWearable;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean equals(Object o);

    public abstract void applyEffect(Character target);

    public ImageView getImage() {
        return image;
    }
}
