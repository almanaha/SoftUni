package SetsAndMaps.Exercises;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.HashMap;
        import java.util.Map;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phonebook = new HashMap<>();

        String input;
        while (!"search".equals(input = sc.readLine())){
            String[] data = input.split("-");
            phonebook.putIfAbsent(data[0], data[1]);
        }
        while (!"stop".equals(input = sc.readLine())){
            if (phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            }else{
                System.out.printf("Contact %s does not exist.\n",input);
            }
        }

    }
}
