package DefiningClasses.Generics.JarOfT;

import java.util.ArrayDeque;

public class Jar<T>{
    public ArrayDeque<T> storage;

    public Jar(){
        this.storage = new ArrayDeque<>();
    }
    public void add(T elemenet){
        this.storage.push(elemenet);
    }
    public T remove(){
        return this.storage.pop();
    }
}
