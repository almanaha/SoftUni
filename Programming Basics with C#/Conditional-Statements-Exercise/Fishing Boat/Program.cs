using System;

namespace Fishing_Boat
{
    class Program
    {
        static void Main()
        {
            double budget = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();
            double fisherMen = double.Parse(Console.ReadLine());

            double price = 0;
            if(season == "Spring")
            {
                price = 3000;
            }
            if (season == "Summer")
            {
                price = 4200;
            }
            if (season == "Autumn")
            {
                price = 4200;
            }
            if (season == "Winter")
            {
                price = 2600;
            }

            if(fisherMen <= 6)
            {
                price *= 0.9;
            }
            else if(fisherMen >= 7 && fisherMen <= 11)
            {
                price *= 0.85;
            }
            else if(fisherMen >= 12)
            {
                price *= 0.75;
            }

            if(fisherMen % 2 == 0 && season != "Autumn")
            {
                price *= 0.95;
            }

            if(price <= budget)
            {
                double total = budget - price;
                Console.WriteLine($"Yes! You have {total:F2} leva left.");
            }
            else if(price > budget)
            {
                double total = price - budget;
                Console.WriteLine($"Not enough money! You need {total:F2} leva.");
            }
        }
    }
}
