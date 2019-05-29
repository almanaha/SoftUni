using System;
class Program
{
    static void Main()
    {
        double budget = double.Parse(Console.ReadLine());
        double areaOfHouse = double.Parse(Console.ReadLine());
        int windows = int.Parse(Console.ReadLine());
        double styrofoam = double.Parse(Console.ReadLine()); // 1 package in kubic meters
        double styrofoamPrice = double.Parse(Console.ReadLine()); // for 1 package

        double totalArea = areaOfHouse - (windows * 2.4); // area without windows
        double wastage = totalArea + (totalArea * 0.1);
        double packagesNeeded = Math.Ceiling(wastage / styrofoam);
        double price = packagesNeeded * styrofoamPrice;

        if (budget >= price)
        {
            double left = budget - price;
            Console.WriteLine($"Spent: {price:F2}");
            Console.WriteLine($"Left: {left:F2}");
        }
        else
        {
            double needed = price - budget;
            Console.WriteLine($"Need more: {needed:F2}");
        }

    }
}

