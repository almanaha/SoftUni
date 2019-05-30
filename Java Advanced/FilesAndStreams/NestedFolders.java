package FilesAndStreams;

import java.io.File;
import java.util.*;

public class NestedFolders {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "\\paths\\Files-and-Streams";
        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {

            File current = dirs.poll();
            Arrays.stream(Objects.requireNonNull(current.listFiles()))
                    .filter(File::isDirectory)
                    .forEach(dirs::offer);

            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
