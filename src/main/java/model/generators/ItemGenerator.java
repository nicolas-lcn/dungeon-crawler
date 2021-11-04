package model.generators;

import model.Item;

public abstract class ItemGenerator implements Generator<Item>{
    @Override
    public abstract Item generate();
}
