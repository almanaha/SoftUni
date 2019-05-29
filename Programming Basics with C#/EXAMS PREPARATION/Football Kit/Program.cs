using System;
namespace Football_Kit
{
    class Program
    {
        static void Main()
        {
            double priceOfTshirt = double.Parse(Console.ReadLine());
            double moneyForWinning = double.Parse(Console.ReadLine());

            double priceOfShorts = priceOfTshirt * 0.75;
            double priceOfSocks = priceOfShorts * 0.2;
            double priceOfShoes = (priceOfTshirt + priceOfShorts) * 2;
            double totalSum = priceOfTshirt + priceOfShorts + priceOfSocks + priceOfShoes;
            double sumDiscount = totalSum - (totalSum * 0.15);

            if (moneyForWinning <= sumDiscount)
            {
                Console.WriteLine($"Yes, he will earn the world-cup replica ball!");
                Console.WriteLine($"His sum is {sumDiscount:F2} lv.");
            }
            else
            {
                double moreMoney = moneyForWinning - sumDiscount;
                Console.WriteLine("No, he will not earn the world-cup replica ball.");
                Console.WriteLine($"He needs {moreMoney:F2} lv. more.");
            }


        }
    }
}
