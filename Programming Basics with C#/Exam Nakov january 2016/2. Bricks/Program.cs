using System;

class Bricks
{
    static void Main()
    {
        var bricks = double.Parse(Console.ReadLine());
        var workers = double.Parse(Console.ReadLine());
        var capacity = double.Parse(Console.ReadLine());

        var bricksPerRound = workers * capacity;

        var total = Math.Ceiling(bricks / bricksPerRound);

        Console.WriteLine(total);
    }
}

