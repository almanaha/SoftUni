using System;
namespace _4.Print_and_sum
{
    class Program
    {
        static void Main()
        {
            int num = int.Parse(Console.ReadLine());
            int num1 = int.Parse(Console.ReadLine());
            int total = 0;

            for (int i = num; i <= num1; i++)
            {
                Console.Write(i + " ");
                total += i;
            }
            Console.WriteLine();
            Console.WriteLine($"Sum: {total}");
            
        }
    }
}
