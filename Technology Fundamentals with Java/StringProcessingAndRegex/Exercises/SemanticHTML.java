package StringProcessingAndRegex.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Pattern openDiv =Pattern.compile("(<div>).*?(\\s*(?:id|class)(?:\\s*=\\s*\")(\\w+)\")");
        Pattern closeDiv = Pattern.compile("(<\\\\/div>\\s*<!--\\s*(\\w+)\\s*-->)");

        String line;
        while (!"END".equals(line = sc.readLine())){
            Matcher openMatch = openDiv.matcher(line);
            Matcher closeMatch = closeDiv.matcher(line);
            while (openMatch.find()){
                line = line.replace(openMatch.group(1), "<" + openMatch.group(3));
                line = line.replace(openMatch.group(2), "");
                line = line.replaceAll("\\s+>", ">");
                line = line.replaceAll("\\s+", " ");
            }
            while (closeMatch.find()){
                line = line.replace(closeMatch.group(1), "</" + closeMatch.group(2) + ">");
            }
            System.out.println(line);
        }
    }
}
