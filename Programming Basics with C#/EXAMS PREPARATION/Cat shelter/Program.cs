using System;
namespace Cat_shelter
{
    class Program
    {
        static void Main()
        {
            int food = int.Parse(Console.ReadLine());

            food *= 1000;

            string input = Console.ReadLine();

            while (input != "Adopted")
            {
                int currentFoor = int.Parse(input);
                food -= currentFoor;


                input = Console.ReadLine();
            }

            if (food >= 0)
            {
                Console.WriteLine($"Food is enough! Leftovers: {food} grams.");
            }
            else
            {
                Console.WriteLine($"Food is not enough. You need {food*-1} grams more.");
            }
        }
    }
}
