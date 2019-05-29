using System;
class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        for (int first = 1; first <= 9; first++)
        {
            for (int second = 1; second <= 9; second++)
            {
                for (int third = 1; third <= 9; third++)
                {
                    for (int fourth = 1; fourth <= 9; fourth++)
                    {
                        int sum1 = first + second;
                        int sum2 = third + fourth;
                        if (sum1 == sum2 && n % sum1 == 0)
                        {
                            Console.Write($"{first}{second}{third}{fourth} ");
                        }
                    }
                }
            }
        }
    }
}

