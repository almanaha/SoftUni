using System;
class Program
{
    static void Main()
    {
        int x1 = int.Parse(Console.ReadLine());
        int y1 = int.Parse(Console.ReadLine());
        int x2 = int.Parse(Console.ReadLine());
        int y2 = int.Parse(Console.ReadLine());
        int x3 = int.Parse(Console.ReadLine());
        int y3 = int.Parse(Console.ReadLine());

        double side = Math.Abs(x2 - x3);
        double heigth = Math.Abs(y2 - y1);

        double area = side * heigth / 2;
        Console.WriteLine(area);
    }
}

