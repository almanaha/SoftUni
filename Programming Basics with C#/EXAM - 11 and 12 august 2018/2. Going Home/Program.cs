using System;
namespace _2.Going_Home
{
    class Program
    {
        static void Main()
        {
            double km = double.Parse(Console.ReadLine());
            double gasoline = double.Parse(Console.ReadLine());
            double gasolinePrice = double.Parse(Console.ReadLine());
            double money = double.Parse(Console.ReadLine());

            double cost = (km * gasoline) / 100;
            double totalCost = cost * gasolinePrice;

            if (money >= totalCost)
            {
                double total = money - totalCost;
                Console.WriteLine($"You can go home. {Math.Abs(total):F2} money left.");
            }
            else
            {
                double leftMoney = money / 5;
                Console.WriteLine($"Sorry, you cannot go home. Each will receive {leftMoney:F2} money.");
            }
        }
    }
}
