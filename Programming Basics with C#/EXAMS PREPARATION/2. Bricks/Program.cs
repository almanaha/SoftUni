using System;
class Program
{
    static void Main()
    {
        int countOfBricks = int.Parse(Console.ReadLine());
        int workers = int.Parse(Console.ReadLine());
        int m = int.Parse(Console.ReadLine());

        double roundPerWorkers = workers * m;
        double totalRounds = Math.Ceiling(countOfBricks / roundPerWorkers);
        Console.WriteLine(totalRounds);
    }
}

