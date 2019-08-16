package DefiningClasses.Generics.JarOfT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Jar<String> jar = new Jar<>();

        jar.add("Ivaylo");
        jar.add("Tenev");

        System.out.println(jar.remove());
    }
}
