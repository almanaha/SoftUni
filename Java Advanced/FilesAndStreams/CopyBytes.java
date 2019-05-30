package FilesAndStreams;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "\\paths\\input.txt";
        String pathOut = userDir + "\\paths\\output2.txt";

        try (FileInputStream fileInputStream = new FileInputStream(pathIn);
             FileOutputStream fileOutputStream = new FileOutputStream(pathOut))
        {
            int oneByte;
            while ((oneByte = fileInputStream.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    fileOutputStream.write(oneByte);
                } else {

                    String digits = String.valueOf(oneByte);

                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
