using System;
namespace Beer_and_chips
{
    class Program
    {
        static void Main()
        {
            string name = Console.ReadLine();
            double budget = double.Parse(Console.ReadLine());
            int bottles = int.Parse(Console.ReadLine());
            int chips = int.Parse(Console.ReadLine());

            double sumBeer = 1.20 * bottles;
            double packageChips = sumBeer * 0.45;
            double totalChips = Math.Ceiling(packageChips * chips);
            double totalMoney = sumBeer + totalChips;

            if (budget >= totalMoney)
            {
                double money = budget - totalMoney;
                Console.WriteLine($"{name} bought a snack and has {money:F2} leva left.");
            }
            else
            {
                double money = totalMoney - budget;
                Console.WriteLine($"{name} needs {money:F2} more leva!");
            }
        }
    }
}
