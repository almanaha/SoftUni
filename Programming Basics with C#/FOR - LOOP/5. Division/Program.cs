using System;
class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        for (int i = 1; i <= n; i++)
        {
            int num = int.Parse(Console.ReadLine());
            if (num % 2 == 0)
            {
                p1++;
            }
            if (num % 3 == 0)
            {
                p2++;
            }
            if (num % 4 == 0)
            {
                p3++;
            }
        }
        double first = (p1 / n) * 100;
        double second = (p2 / n) * 100;
        double third = (p3 / n) * 100;

        Console.WriteLine($"{first:F2}%");
        Console.WriteLine($"{second:F2}%");
        Console.WriteLine($"{third:F2}%");
    }
}

