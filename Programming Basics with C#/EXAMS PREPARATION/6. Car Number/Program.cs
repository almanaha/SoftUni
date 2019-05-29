using System;
class Program
{
    static void Main()
    {
        int start = int.Parse(Console.ReadLine());
        int end = int.Parse(Console.ReadLine());

        for (int i = start; i <= end; i++)
        {
            for (int k = start; k <= end; k++)
            {
                for (int j = start; j <= end; j++)
                {
                    for (int g = start; g <= end; g++)
                    {
                        int sum = k + j;
                        if ((i % 2 == 0 && g % 2 != 0) && i > g && sum % 2 == 0)
                        {
                            Console.Write($"{i}{k}{j}{g} ");
                        }
                        if ((i % 2 == 1 && g % 2 == 0) && i > g && sum % 2 == 0)
                        {
                            Console.Write($"{i}{k}{j}{g} ");
                        }
                    }
                }
            }
        }

    }
}

