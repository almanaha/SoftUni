using System;
class Exam
{
    static void Main()
    {
        string cake = Console.ReadLine();
        int countOfCakes = int.Parse(Console.ReadLine());
        int day = int.Parse(Console.ReadLine());

        double priceOfCake = 0;

        if (day <= 15)
        {
            switch (cake)
            {
                case "Cake": priceOfCake = 24; break;
                case "Souffle": priceOfCake = 6.66; break;
                case "Baklava": priceOfCake = 12.60; break;
            }
        }
        else
        {
            switch (cake)
            {
                case "Cake": priceOfCake = 28.70; break;
                case "Souffle": priceOfCake = 9.80; break;
                case "Baklava": priceOfCake = 16.98; break;
            }
        }
        double totalSum = priceOfCake * countOfCakes;
        if (day <= 22)
        {
            if (totalSum >= 100 && totalSum <= 200)
            {
                totalSum *= 0.85;
            }
            else if (totalSum > 200)
            {
                totalSum *= 0.75;
            }
        }
        if (day <= 15)
        {
            totalSum *= 0.9;
        }
        Console.WriteLine($"{totalSum:F2}");
    }
}