package model.generators;


import model.components.Component;


public abstract class ComponentGenerator implements Generator<Component> {
    @Override
    public abstract Component generate();

    @Override
    public abstract void reset();
}
