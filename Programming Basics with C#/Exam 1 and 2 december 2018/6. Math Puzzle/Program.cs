using System;
namespace _6.Math_Puzzle
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            bool isCombination = true;

            for (int a = 1; a <= 30; a++)
            {
                for (int b = 1; b <= 30; b++)
                {
                    for (int c = 1; c <= 30; c++)
                    {
                        int sum1 = a + b + c;
                        int sum2 = a * b * c;

                        if (a < b && b < c)
                        {
                            if (sum1 == n)
                            {
                                isCombination = false;
                                Console.WriteLine($"{a} + {b} + {c} = {n}");
                            }
                        }

                        if (a > b && b > c)
                        {
                            if (sum2 == n)
                            {
                                isCombination = false;
                                Console.WriteLine($"{a} * {b} * {c} = {n}");
                            }
                        }
                    }
                }
            }

            if (isCombination)
            {
                Console.WriteLine("No!");
            }
        }
    }
}
