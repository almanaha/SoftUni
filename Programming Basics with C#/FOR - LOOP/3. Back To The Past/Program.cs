using System;
class Program
{
    static void Main()
    {
        double money = double.Parse(Console.ReadLine());
        int year = int.Parse(Console.ReadLine());

        double total = money;
        int yearCounter = 18;

        for (int past = 1800; past <= year; past++)
        {
            if (past == 1800)
            {
                total -= 12000;
                continue;
            }
            yearCounter++;

            if (past % 2 == 0)
            {
                total -= 12000;
            }
            if (past % 2 == 1)
            {
                total -= 12000 + (yearCounter * 50);
            }
        }
        if (total >= 0)
        {
            Console.WriteLine($"Yes! He will live a carefree life and will have {total:F2} dollars left.");
        }
        else
        {
            Console.WriteLine($"He will need {Math.Abs(total):F2} dollars to survive.");
        }
    }
}

