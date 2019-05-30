package FilesAndStreams;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class ListFiles {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "\\paths\\Files-and-Streams";
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {

                Arrays.stream(Objects.requireNonNull(file.listFiles()))
                        .filter(e -> !e.isDirectory())
                        .forEach(e -> System.out.printf("%s: [%s]%n",
                                e.getName(),
                                e.length()));
            }
        }
    }
}
