using System;
namespace _12.Even_Number
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; ; i++)
            {
                if (n % 2 == 1)
                {
                    Console.WriteLine("Please write an even number.");
                }
                else
                {
                    Console.WriteLine($"The number is: {Math.Abs(n)}");
                    break;
                }
                n = int.Parse(Console.ReadLine());
            }
               
        }
    }
}
