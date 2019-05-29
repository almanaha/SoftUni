using System;
class Program
{
    static void Main()
    {
        int x = int.Parse(Console.ReadLine());
        int y = int.Parse(Console.ReadLine());

        bool firstArea = x >= 2 && x <= 12 && y >= -3 && y <= 1;
        bool secondArea = x >= 4 && x <= 10 && y >= -5 && y <= 3;

        if (firstArea || secondArea)
        {
            Console.WriteLine("in");
        }
        else
        {
            Console.WriteLine("out");
        }
    }
}

