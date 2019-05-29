using System;
class Program
{
    static void Main()
    {
        int km = int.Parse(Console.ReadLine());
        string time = Console.ReadLine();

        double taxi = 0;

        if (time == "day")
        {
            taxi = 0.79;
        }
        else
        {
            taxi = 0.9;
        }

        double price = 0;
        if (km < 20)
        {
            price = 0.70 + (km * taxi);
        }
        else if (km < 100)
        {
            price = km * 0.09;
        }
        else
        {
            price = km * 0.06;
        }

        Console.WriteLine($"{price:F2}");
    }
}

