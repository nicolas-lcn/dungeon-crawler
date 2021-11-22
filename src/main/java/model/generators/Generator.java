package model.generators;

public interface Generator<T>{
    public T generate();
    void reset();
}
