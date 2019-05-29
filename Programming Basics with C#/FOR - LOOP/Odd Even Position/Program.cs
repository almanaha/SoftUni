using System;
namespace Odd_Even_Position
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            double oddSum = 0;
            double oddMin = int.MaxValue;
            double oddMax = int.MinValue;
            double evenSum = 0;
            double evenMin = int.MaxValue;
            double evenMax = int.MinValue;

            for (int i = 1; i <= n; i++)
            {
                double num = double.Parse(Console.ReadLine());
                if (i % 2==1)
                {
                    oddSum += num;
                    if (num < oddMin)
                    {
                        oddMin = num;
                    }
                    if (num > oddMax)
                    {
                        oddMax = num;
                    }
                }
                else
                {
                    evenSum += num;
                    if (num < evenMin)
                    {
                        evenMin = num;
                    }
                    if (num > evenMax)
                    {
                        evenMax = num;
                    }
                }
            }
            Console.WriteLine($"OddSum={oddSum}");

            if (oddMin != int.MaxValue)
            {
                Console.WriteLine($"OddMin={oddMin}");
            }
            else
            {
                Console.WriteLine($"OddMin=No");
            }

            if (oddMax != int.MinValue)
            {
                Console.WriteLine($"OddMax={oddMax}");
            }
            else
            {
                Console.WriteLine($"OddMax=No");
            }

            Console.WriteLine($"EvenSum={evenSum}");
            if (evenMin != int.MaxValue)
            {
                Console.WriteLine($"EvenMin={evenMin}");
            }
            else
            {
                Console.WriteLine($"EvenMin=No");
            }

            if (evenMax != int.MinValue)
            {
                Console.WriteLine($"EvenMax={evenMax}");
            }
            else
            {
                Console.WriteLine($"EvenMax=No");
            }
        }
    }
}
