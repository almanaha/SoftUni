using System;
class Program
{
    static void Main()
    {
        int controlNum = int.Parse(Console.ReadLine());

        bool isPrinted = false;

        for (int a = 1; a <= 30; a++)
        {
            for (int b = 1; b <= 30; b++)
            {
                for (int c = 1; c <= 30; c++)
                {
                    if (a < b && b < c && a + b + c == controlNum)
                    {
                        isPrinted = true;
                        Console.WriteLine($"{a} + {b} + {c} = {controlNum}");
                    }
                    else if (a > b && b > c && a * b * c == controlNum)
                    {
                        isPrinted = true;
                        Console.WriteLine($"{a} * {b} * {c} = {controlNum}");
                    }
                }
            }
        }

        if (!isPrinted)
        {
            Console.WriteLine("No!");
        }
    }
}

