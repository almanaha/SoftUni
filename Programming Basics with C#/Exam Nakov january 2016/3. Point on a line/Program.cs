using System;
namespace _3.Point_on_a_line
{
    class Program
    {
        static void Main()
        {
            var first = int.Parse(Console.ReadLine());
            var second = int.Parse(Console.ReadLine());
            var point = int.Parse(Console.ReadLine());

            var left = Math.Min(first, second);
            var right = Math.Max(first, second);

            var leftDistance = Math.Abs(point - left);
            var rightDistance = Math.Abs(point - right);
            var distance = Math.Min(leftDistance, rightDistance);

            if ((point >= left) && (point <= right))
            {
                Console.WriteLine("in");
                Console.WriteLine(distance);
            }
            else
            {
                Console.WriteLine("out");
                Console.WriteLine(distance);
            }
        }
    }
}
