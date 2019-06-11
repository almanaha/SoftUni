package Generics.Threeuple;

class Threeuple<F, S, T> {
    private F first;
    private S second;
    private T third;

    public Threeuple(F first, S second, T third) {
        this.setFirst(first);
        this.setSecond(second);
        this.setThird(third);
    }

    F getFirst() {
        return first;
    }

    void setFirst(F first) {
        this.first = first;
    }

    S getSecond() {
        return second;
    }

    void setSecond(S second) {
        this.second = second;
    }

    T getThird() {
        return third;
    }

    void setThird(T third) {
        this.third = third;
    }

    void print() {
        System.out.println(String.format("%s -> %s -> %s", this.first, this.second, this.third));
    }
}
