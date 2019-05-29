using System;
namespace Shoping
{
    class Program
    {
        static void Main()
        {
            double budget = double.Parse(Console.ReadLine());
            int sweetsCount = int.Parse(Console.ReadLine());
            double littersMilk = double.Parse(Console.ReadLine());

            double chochocolate = 0.65;
            double milk = 2.70;
            double sumMilk = littersMilk * milk;
            double mandarin = Math.Floor(sweetsCount - (sweetsCount * 0.35));
            double sumSweets = sweetsCount * chochocolate;
            double mandarinPrice = mandarin * 0.20;

            double sum = sumMilk + sumSweets + mandarinPrice;
            if (sum < budget)
            {
                double total = budget - sum;
                Console.WriteLine($"You got this, {total:F2} money left!");
            }
            else
            {
                double moneyNeeded = sum - budget;
                Console.WriteLine($"Not enough money, you need {moneyNeeded:F2} more!");
            }
        }
    }
}
