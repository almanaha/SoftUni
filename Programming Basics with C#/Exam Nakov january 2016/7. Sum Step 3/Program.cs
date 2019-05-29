using System;
namespace _7.Sum_Step_3
{
    class Program
    {
        static void Main()
        {
            var n = int.Parse(Console.ReadLine());

            var sum1 = 0;
            var sum2 = 0;
            var sum3 = 0;

            for (int i = 1; i <= n; i++)
            {
                var num = int.Parse(Console.ReadLine());
                if (i % 3 == 0) sum1 += num; // 1-во число + всяко 3-то след него
                if (i % 3 == 1) sum2 += num; // 2-во число + всяко 3-то след него
                if (i % 3 == 2) sum3 += num; // 3-во число + всяко 3-то след него            
            }
                Console.WriteLine($"Sum1 = {sum1}");
            Console.WriteLine($"Sum2 = {sum2}");
            Console.WriteLine($"Sum3 = {sum3}");
        }
    }
}
