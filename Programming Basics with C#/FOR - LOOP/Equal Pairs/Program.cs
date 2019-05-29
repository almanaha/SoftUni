using System;
namespace Equal_Pairs
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            int firstSum = 0;
            int maxDiff = int.MinValue;
            int lastSum = 0;
            bool areTheyEqual = true;

            for (int i = 0; i < n; i++)
            {
                int firstNum = int.Parse(Console.ReadLine());
                int secondNum = int.Parse(Console.ReadLine());
                int sum = firstNum + secondNum;

                if (i == 0)
                {
                    firstSum = sum;
                    lastSum = sum;
                }

                if (sum != firstSum)
                {
                    areTheyEqual = false;
                }

                if (Math.Abs(sum - lastSum) > maxDiff)
                {
                    maxDiff = Math.Abs(sum - lastSum);
                }
                lastSum = sum;
            }

            if (areTheyEqual)
            {
                Console.WriteLine($"Yes, value={firstSum}");
            }
            else
            {
                Console.WriteLine($"No, maxdiff={maxDiff}");
            }
        }
    }
}
