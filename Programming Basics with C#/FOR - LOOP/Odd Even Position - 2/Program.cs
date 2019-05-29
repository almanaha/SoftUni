using System;

class Odd_Even_Position
{
    static void Main(string[] args)
    {
        Console.Write("n = ");
        double n = double.Parse(Console.ReadLine());
        double EvenSum = 0.0;
        double OddSum = 0.0;
        var EvenMax = double.MinValue;
        var EvenMin = double.MaxValue;
        var OddMax = double.MinValue;
        var OddMin = double.MaxValue;

        for (int i = 1; i <= n; i++)
        {
            if (i % 2 != 0)
            {
                var currentNum = double.Parse(Console.ReadLine());
                OddSum = OddSum + currentNum;

                if (currentNum < OddMin)
                {
                    OddMin = currentNum;
                }

                if (currentNum > OddMax)
                {
                    OddMax = currentNum;
                }
            }

            else if (i % 2 == 0)
            {
                var currentNum = double.Parse(Console.ReadLine());
                EvenSum = EvenSum + currentNum;

                if (currentNum < EvenMin)
                {
                    EvenMin = currentNum;
                }
                if (currentNum > EvenMax)
                {
                    EvenMax = currentNum;
                }
            }

        }
        if (n != 0 && n != 1)
        {
            Console.WriteLine("OddSum={0},OddMin={1},OddMax={2},EvenSum={3},EvenMin={4},EvenMax={5}", OddSum, OddMin,
            OddMax, EvenSum, EvenMin, EvenMax);
        }
        else if (n == 0)
        {
            Console.WriteLine("OddSum={0},OddMin=No,OddMax=No,EvenSum={1},EvenMin=No,EvenMax=No", OddSum, EvenSum);
        }
        else if (n == 1)
        {
            Console.WriteLine("OddSum={0},OddMin={1},OddMax={2},EvenSum={3},EvenMin=No,EvenMax=No", OddSum, OddMin, OddMax,
                EvenSum);
        }
        else if (n < 0)
        {
            Console.WriteLine("OddSum={0},OddMin=No,OddMax=No,EvenSum={1},EvenMin=No,EvenMax=No", OddSum, EvenSum);
        }
    }
}

