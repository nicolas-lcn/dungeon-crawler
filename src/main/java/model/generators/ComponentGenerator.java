package model.generators;

import model.Potion;
import model.components.Component;
import model.components.Monster;

public abstract class ComponentGenerator implements Generator<Component> {
    @Override
    public abstract Component generate();

    @Override
    public abstract void reset();
}
