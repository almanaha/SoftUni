using System;
namespace Softuni_part_four
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            for (int i = 1; i <= count; i++)
            {
                string ingradient = Console.ReadLine();

                bool hasEggs = false;
                bool hasFlour = false;
                bool hasSugar = false;

                while (true)
                {
                    if (ingradient == "eggs")
                    {
                        hasEggs = true;
                    }
                    else if (ingradient == "flour")
                    {
                        hasFlour = true;
                    }
                    else if (ingradient == "sugar")
                    {
                        hasSugar = true;
                    }
                    else if (ingradient == "Bake!")
                    {
                        if (hasEggs && hasFlour && hasSugar == true)
                        {
                            Console.WriteLine($"Baking batch number {i}...");
                            break;
                        }
                        else
                        {
                            Console.WriteLine("The batter should contain flour, eggs and sugar!");

                        }
                    }
                    ingradient = Console.ReadLine();
                }
            }
        }
    }
}