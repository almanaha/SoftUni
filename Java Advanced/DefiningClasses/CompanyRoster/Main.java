package DefiningClasses.CompanyRoster;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Department.init();

        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            double salary = Double.parseDouble(data[1]);
            String email = null;
            Integer age = null;

            if (data.length == 6) {
                email = data[4];
                age = Integer.parseInt(data[5]);
            } else if (data.length == 5) {
                if (data[4].contains("@")) email = data[4];
                else age = Integer.parseInt(data[4]);
            }
            Department.add(new Employee(data[0], salary, data[2], data[3], email, age));
        }
        Department.theBest();
    }
}
