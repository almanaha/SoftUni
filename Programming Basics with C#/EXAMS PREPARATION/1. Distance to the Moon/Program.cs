using System;
class Program
{
    static void Main()
    {
        double speed = double.Parse(Console.ReadLine());
        double km = double.Parse(Console.ReadLine());

        double totalDistance = 384400 * 2;
        double time = Math.Ceiling(totalDistance / speed);
        int totalTime = (int)time + 3;
        double gasoline = km * totalDistance / 100;
        Console.WriteLine(totalTime);
        Console.WriteLine(gasoline);

    }
}

