package Generics.Jarr;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();

        jar.add("g");
        jar.add("S");
        jar.add("V");

        System.out.println(jar.remove());
    }
}
