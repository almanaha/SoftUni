using System;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {
            int boughtFood = int.Parse(Console.ReadLine());
            int eatenFood = 0;
            boughtFood = boughtFood * 1000;
            while (true)
            {
                string command = Console.ReadLine();
                if (command == "Adopted")
                {
                    break;
                }
                eatenFood += int.Parse(command);

            }

            if (boughtFood >= eatenFood)
            {
                Console.WriteLine($"Food is enough! Leftovers: {boughtFood - eatenFood} grams.");
            }
            else
            {
                Console.WriteLine($"Food is not enough. You need {eatenFood - boughtFood} grams more.");
            }
        }
    }
}
