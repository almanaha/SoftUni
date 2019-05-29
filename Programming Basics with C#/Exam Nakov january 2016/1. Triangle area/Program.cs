using System;
namespace _1.Triangle_area
{
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

            var side = Math.Abs(x2 - x3);
            var heigth = Math.Abs(y1 - y3);

            var area = side * heigth / 2.0;
            Console.WriteLine(area);
        }
    }
}
