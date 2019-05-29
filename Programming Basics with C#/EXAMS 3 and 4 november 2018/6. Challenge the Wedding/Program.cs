using System;
namespace _6.Challenge_the_Wedding
{
    class Program
    {
        static void Main()
        {
            int mNumber = int.Parse(Console.ReadLine());
            int fNumber = int.Parse(Console.ReadLine());
            int tablesNumber = int.Parse(Console.ReadLine());

            for (int a = 1; a <= mNumber; a++)
            {
                for (int b = 1; b <= fNumber; b++)
                {
                    if (tablesNumber == 0)
                    {
                        break;
                    }
                    Console.Write($"({a} <-> {b}) ");
                    tablesNumber--;
                }
            }
        }
    }
}
