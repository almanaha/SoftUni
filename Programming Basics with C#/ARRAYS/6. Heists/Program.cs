using System;
using System.Linq;

namespace _6._Heists
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] priceOfLoot = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int jewelsPrice = priceOfLoot[0];
            int goldPrICE = priceOfLoot[1];
            long totalLoot = 0L;
            long totalExpenses = 0L;

            string[] tokens = Console.ReadLine().Split(' ').ToArray();
            while (tokens[0] != "Jail" && tokens[1] != "Time")
            {
                string loot = tokens[0];
                int expenses = int.Parse(tokens[1]);
                totalExpenses += expenses;
                for (int i = 0; i < loot.Length; i++)
                {
                    if (loot[i] == '%')
                    {
                        totalLoot += jewelsPrice;
                    }
                    else if (loot[i] == '$')
                    {
                        totalLoot += goldPrICE;
                    }
                    tokens = Console.ReadLine().Split(' ').ToArray();
                }
                if (totalExpenses >= totalLoot)
                {
                    Console.WriteLine($"Heist will continue. Total earnings: {totalLoot - expenses}");
                }
                else
                {
                    Console.WriteLine($"Have to find another job.Lost: {expenses - totalLoot}.");
                }
            }

        }
    }
}
