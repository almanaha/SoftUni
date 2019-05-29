using System;

class Program
{
    static void Main()
    {
        int tables = int.Parse(Console.ReadLine());
        double length = double.Parse(Console.ReadLine()); // in meters
        double width = double.Parse(Console.ReadLine()); // in meters

        double totalArea1 = tables * (length + 2 * 0.3) * (width + 2 * 0.3);
        double totalArea2 = tables * (length / 2) * (length / 2);
        double usd = (totalArea1 * 7) + (totalArea2 * 9);
        double leva = usd * 1.85;

        Console.WriteLine($"{usd:F2}");
        Console.WriteLine($"{leva:F2}");
    }
}

