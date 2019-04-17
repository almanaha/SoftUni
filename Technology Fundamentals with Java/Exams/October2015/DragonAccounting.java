package Exams.October2015;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class DragonAccounting {
    public static BigDecimal month = new BigDecimal("30");
    public static BigDecimal raise = new BigDecimal("1.006");

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<Employee> employees = new LinkedList<>();
        boolean hasBankrupt = false;
        int days = 0;

        BigDecimal initialCapital = new BigDecimal(sc.readLine());
        String input;
        while (!"END".equals(input = sc.readLine())) {
            String[] data = input.split(";");
            long hired = Long.parseLong(data[0]);
            long fired = Long.parseLong(data[1]);
            BigDecimal salary = new BigDecimal(data[2]);

            //hire employees
            Employee employee = new Employee(hired, 0, salary);
            employees.add(employee);


            days++;
            for (Employee e : employees) {
                e.day++;
                if (e.day % 365 == 0) {
                    e.salary = e.salary.multiply(raise);
                }

                //pay salaries
                if (days % 30 == 0) {
                    if (e.day < 30) {
                        BigDecimal moneyToReceive = e.salary
                                .divide(month, 9, BigDecimal.ROUND_UP)
                                .setScale(7, BigDecimal.ROUND_DOWN)
                                .multiply(new BigDecimal(e.day))
                                .multiply(new BigDecimal(e.count));

                        initialCapital = initialCapital.subtract(moneyToReceive);

                    } else {
                        BigDecimal moneyToReceive = e.salary
                                .divide(month, 9, BigDecimal.ROUND_UP)
                                .setScale(7, BigDecimal.ROUND_DOWN)
                                .multiply(month)
                                .multiply(new BigDecimal(e.count));

                        initialCapital = initialCapital.subtract(moneyToReceive);
                    }
                }

                //fire employees
                if (fired > 0) {
                    e.count -= fired;
                    if (e.count < 0) {
                        fired = Math.abs(e.count);
                        e.count = 0;
                    } else {
                        fired = 0;
                    }

                }
            }

            // we start from 3, to skip first lines
            for (int i = 3; i < data.length; i++) {
                String[] activities = data[i].split(":");
                String reason = activities[0];
                BigDecimal money = new BigDecimal(activities[1]);

                if (reason.equals("Product dedvelopment") ||
                        reason.equals("Unconditional funding")) {
                    initialCapital = initialCapital.add(money);
                } else {
                    initialCapital = initialCapital.subtract(money);
                }
            }

            if (initialCapital.compareTo(BigDecimal.ZERO) <= 0) {
                hasBankrupt = true;
                break;
            }
        }
        if (hasBankrupt) {
            System.out.println("BANKRUPTCY: " + initialCapital.setScale(4, BigDecimal.ROUND_DOWN).abs());
        } else {
            BigInteger employeesCount = BigInteger.ZERO;

            for (Employee es : employees) {
                employeesCount = employeesCount.add(new BigInteger(Long.toString(es.count)));
            }

            System.out.println(employeesCount + " " + initialCapital.setScale(4, BigDecimal.ROUND_DOWN).abs());
        }

    }

    static class Employee {
        public long count;
        public int day;
        public BigDecimal salary;

        public Employee(long count, int day, BigDecimal salary) {
            this.count = count;
            this.day = day;
            this.salary = salary;
        }

    }
}
