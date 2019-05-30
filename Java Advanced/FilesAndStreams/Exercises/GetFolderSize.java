package FilesAndStreams.Exercises;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class GetFolderSize {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "\\sources\\Exercises Resources";


        System.out.printf("Folder size: %d", getFolderSize(new File(path)));
    }

    private static long getFolderSize(File file) {

        long length = 0L;

        if (file != null && file.exists()) {

            length += Arrays.stream(Objects.requireNonNull(file.listFiles()))
                    .mapToLong(f -> f.isDirectory() ? getFolderSize(f) : f.length())
                    .sum();

        }
        return length;
    }
}