using System;

class Program
{
    static void Main()
    {
        string line = string.Empty;
        while ((line = Console.ReadLine()) != "End")
        {
            string destination = line;
            double budget = double.Parse(Console.ReadLine());

            double money = 0;
            string savings = string.Empty;
            while (true)
            {
                savings = Console.ReadLine();
                if (savings == "End")
                {
                    return;
                }

                money += double.Parse(savings);

                if (money >= budget)
                {
                    Console.WriteLine($"Going to {destination}!");
                    break;
                }
            }
        }
    }
}
