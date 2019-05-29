using System;
namespace _1.Shopping_Time
{
    class Program
    {
        static void Main()
        {
            double restTime = double.Parse(Console.ReadLine());
            double price1 = double.Parse(Console.ReadLine());
            double price2 = double.Parse(Console.ReadLine());
            double price3 = double.Parse(Console.ReadLine());

            double coffeeTime = restTime - 5;
            double relaxingTime = coffeeTime - 10;
            double spentMoney1 = price1 * 3;
            double spentMoney2 = price2 * 2;

            double totalMoney = price3 + spentMoney1 + spentMoney2;

            Console.WriteLine($"{totalMoney:F2}");
            Console.WriteLine(relaxingTime);

        }
    }
}
