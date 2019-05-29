using System;
namespace CAKE
{
    class Program
    {
        static void Main()
        {
            int width = int.Parse(Console.ReadLine());
            int length = int.Parse(Console.ReadLine());

            int cake = width * length;

            while (true)
            {
                string input = Console.ReadLine();
                if (input != "STOP")
                {
                    cake -= int.Parse(input);
                }
                else
                {
                    Console.WriteLine($"{cake} pieces are left.");
                    break;
                }

                if (cake < 0)
                {
                    Console.WriteLine($"No more cake left! You need {Math.Abs(cake)} pieces more.");
                    break;
                }
            }
        }
    }
}
