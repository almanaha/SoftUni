package Generics.Tuple;

class Tuple<X, Y> {
    private X x;
    private Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    X getX() {
        return x;
    }

    void setX(X x) {
        this.x = x;
    }

    Y getY() {
        return y;
    }

    void setY(Y y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.x, this.y);
    }
}
