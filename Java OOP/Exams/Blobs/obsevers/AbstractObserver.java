package obsevers;

public abstract class AbstractObserver {
    protected Subject subject;

    public abstract void update();
}
