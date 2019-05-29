using System;
namespace _2.Division
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int biggerDiveder = 0;

            if (n % 2 != 0 && n % 3 != 0 && n % 6 != 0 && n % 7 != 0 && n % 10 != 0)
            {
                Console.WriteLine("Not divisible");
            }
            else
            {
                if (n % 2 == 0)
                {
                    biggerDiveder = 2;
                }
                if (n % 3 == 0)
                {
                    biggerDiveder = 3;
                }
                if (n % 6 == 0)
                {
                    biggerDiveder = 6;
                }
                if (n % 7 == 0)
                {
                    biggerDiveder = 7;
                }
                if (n % 10 == 0)
                {
                    biggerDiveder = 10;
                }

                Console.WriteLine($"The number is divisible by {biggerDiveder}");
            }
        }
    }
}
