using System;
namespace New_House
{
    class Program
    {
        static void Main()
        {
            string flowers = Console.ReadLine();
            int countOfFlowers = int.Parse(Console.ReadLine());
            int budget = int.Parse(Console.ReadLine());
            double price = 0;

            if(flowers == "Roses")
            {
                price = countOfFlowers * 5;
                if(countOfFlowers > 80)
                {
                    price *= 0.9;
                }
            }
            else if(flowers == "Dahlias")
            {
                price = countOfFlowers * 3.8;
                if(countOfFlowers > 90)
                {
                    price *= 0.85;
                }
            }
            else if(flowers == "Tulips")
            {
                price = countOfFlowers * 2.8;
                if(countOfFlowers > 80)
                {
                    price *= 0.85;
                }
            }
            else if(flowers == "Narcissus")
            {
                price = countOfFlowers * 3;
                if(countOfFlowers < 120)
                {
                    price *= 1.15;
                }
            }
            else if(flowers == "Gladiolus")
            {
                price = countOfFlowers * 2.5;
                if(countOfFlowers < 80)
                {
                    price *= 1.2;
                }
            }

            if(price > budget)
            {
                double total = price - budget;
                Console.WriteLine($"Not enough money, you need {total:F2} leva more.");
            }
            else
            {
                double total = budget - price;
                Console.WriteLine($"Hey, you have a great garden with {countOfFlowers} {flowers} and {total:F2} leva left.");
            }
        }
    }
}
