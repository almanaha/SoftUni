using System;
namespace CAKE
{
    class Program
    {
        static void Main()
        {
            int widthCake = int.Parse(Console.ReadLine());
            int lengthCake = int.Parse(Console.ReadLine());

            int pieces = widthCake * lengthCake;

            while (pieces >= 0)
            {
                string input = Console.ReadLine();
                if (input == "STOP")
                {
                    Console.WriteLine($"{pieces} pieces are left.");
                    break;
                }

                int cake = int.Parse(input);

                pieces -= cake;
                
            }

            if (pieces <= 0)
            {
                Console.WriteLine($"No more cake left! You need {Math.Abs(pieces)} pieces more.");
            }
        }
    }
}
