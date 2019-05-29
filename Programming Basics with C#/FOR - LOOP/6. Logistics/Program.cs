using System;
class Program
{
    static void Main()
    {
        int loads = int.Parse(Console.ReadLine());

        int totalLoads = 0;

        double bus = 0;
        double truck = 0;
        double train = 0;

        for (int load = 1; load <= loads; load++)
        {
            int tons = int.Parse(Console.ReadLine());
            totalLoads += tons;

            if (tons <= 3)
            {
                bus += tons;
            }
            else if (tons > 3 && tons <= 11)
            {
                truck += tons;
            }
            else
            {
                train += tons;
            }
        }
        double avgSum = (bus * 200 + truck * 175 + train * 120) / totalLoads;
        double p1 = (bus / totalLoads) * 100;
        double p2 = (truck / totalLoads) * 100;
        double p3 = (train / totalLoads) * 100;

        Console.WriteLine($"{avgSum:F2}");
        Console.WriteLine($"{p1:F2}%");
        Console.WriteLine($"{p2:F2}%");
        Console.WriteLine($"{p3:F2}%");
    }
}

