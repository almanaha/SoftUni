using System;
class Program
{
    static void Main()
    {
        int days = int.Parse(Console.ReadLine()); //in month
        double moneyPerDay = double.Parse(Console.ReadLine());
        double usdToLeva = double.Parse(Console.ReadLine()); // in leva

        double monthSalary = days * moneyPerDay;
        double yearlyIncome = monthSalary * 12 + monthSalary * 2.5;
        double afterTaxes = yearlyIncome * 0.75;
        double avgMoneyPerDay = afterTaxes / 365;
        Console.WriteLine($"{avgMoneyPerDay*usdToLeva:F2}");
    }
}

