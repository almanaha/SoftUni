using System;
namespace _5.Sum_3_Elements
{
    class Program
    {
        static void Main()
        {
            var n1 = int.Parse(Console.ReadLine());
            var n2 = int.Parse(Console.ReadLine());
            var n3 = int.Parse(Console.ReadLine());

            var min = Math.Min(Math.Min(n1, n2), n3);
            var max = Math.Max(Math.Max(n1, n2), n3);
            var sum = n1 + n2 + n3;
            var mid = sum - min - max;

            if (min + mid == max)
            {
                Console.WriteLine(min + "+" + mid + "=" + max);
            }
            else
            {
                Console.WriteLine("No");
            }


        }
    }
}
