using System;
namespace Game_Statistics
{
    class Program
    {
        static void Main()
        {
            int minutes = int.Parse(Console.ReadLine());
            string player = Console.ReadLine();

            if (minutes == 0)
            {
                Console.WriteLine("Match has just began!");
            }

            if (minutes < 45)
            {
                Console.WriteLine("First half time.");
                if (minutes >= 1 && minutes <= 10)
                {
                    Console.WriteLine($"{player} missed a penalty.");
                    if (minutes % 2 == 0)
                    {
                        Console.WriteLine($"{player} was injured after the penalty.");
                    }
                }
                else if (minutes > 10 && minutes <= 35)
                {
                    Console.WriteLine($"{player} received yellow card.");
                    if (minutes % 2 == 1)
                    {
                        Console.WriteLine($"{player} got another yellow card.");
                    }
                }
                else if (minutes > 35 && minutes < 45)
                {
                    Console.WriteLine($"{player} SCORED A GOAL !!!");
                }
            }
            if (minutes >= 45)
            {
                Console.WriteLine("Second half time.");
                if (minutes > 45 && minutes <= 55)
                {
                    Console.WriteLine($"{player} got a freekick.");
                    if (minutes % 2 == 0)
                    {
                        Console.WriteLine($"{player} missed the freekick.");
                    }
                }
                else if (minutes > 55 && minutes <= 80)
                {
                    Console.WriteLine($"{player} missed a shot from corner.");
                    if (minutes % 2 == 1)
                    {
                        Console.WriteLine($"{player} has been changed with another player.");
                    }
                }
                else if (minutes > 80 && minutes <= 90)
                {
                    Console.WriteLine($"{player} SCORED A GOAL FROM PENALTY !!!");
                }
            }
        }
    }
}
