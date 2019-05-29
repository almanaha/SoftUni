using System;
class Program
{
    static void Main()
    {
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());
        int count = 0;

        for (int i = a; i <= b; i++)
        {
            for (int i2 = i + 1; i2 <= b; i2++)
            {
                for (int i3 = i2 + 1; i3 <= b; i3++)
                {
                    for (int i4 = i3 + 1; i4 <= b; i4++)
                    {
                        
                        Console.WriteLine($"{i} {i2} {i3} {i4}");
                        count++;
                    }
                }
            }
        }
        if (count <= 0)
        {
            Console.WriteLine("No");
        }
    }
}

