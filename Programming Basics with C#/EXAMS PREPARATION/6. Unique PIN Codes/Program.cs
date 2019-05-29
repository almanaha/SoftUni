using System;
class Program
{
    static void Main()
    {
        int n1 = int.Parse(Console.ReadLine());
        int n2 = int.Parse(Console.ReadLine());
        int n3 = int.Parse(Console.ReadLine());

        for (int i = 1; i <= n1; i++)
        {
            for (int k = 1; k <= n2; k++)
            {
                for (int j = 1; j <= n3; j++)
                {
                    if (i % 2 ==0 && j % 2 == 0 && (k == 2 || k == 3 || k == 5  || k == 7 ))
                    {
                        Console.WriteLine($"{i} {k} {j}");
                    }
                }
            }
        }
    }
}

