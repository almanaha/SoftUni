using System;
class Program
{
    static void Main()
    {
        int first = int.Parse(Console.ReadLine());
        int second = int.Parse(Console.ReadLine());
        int diff1 = int.Parse(Console.ReadLine());
        int diff2 = int.Parse(Console.ReadLine());
        int sum1 = first + diff1;
        int sum2 = second + diff2;

        for (int n = first; n <= sum1; n++)
        {
            if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0)
            {
                continue;
            }
            for (int n1 = second; n1 <= sum2; n1++)
            {
                if (n1 % 2 == 0 || n1 % 3 == 0 || n1 % 5 == 0 || n1 % 7 == 0)
                {
                    continue;
                }
                else
                {
                    Console.WriteLine($"{n}{n1}");
                }
            }
        }
    }
}

