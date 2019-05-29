using System;
class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        double w = double.Parse(Console.ReadLine());
        double h = double.Parse(Console.ReadLine());
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());

        double totalArea = n * n;
        double areaBench = a * b;
        double areaRepair = totalArea - areaBench;
        double areaTiles = w * h;
        double tilesNeeded = areaRepair / areaTiles;
        double timeNeeded = tilesNeeded * 0.2;

        Console.WriteLine(tilesNeeded);
        Console.WriteLine(timeNeeded);
    }
}

