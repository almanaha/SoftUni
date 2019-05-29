using System;
namespace Sum_Numbers
{
    class Program
    {
        static void Main()
        {
            int a = int.Parse(Console.ReadLine());
            double sumOfNumbers = 0;

            for (int i = 0; i < a; i++)
            {
                double n = double.Parse(Console.ReadLine());
                sumOfNumbers = sumOfNumbers + n;
            }
            Console.WriteLine(sumOfNumbers);
        }
    }
}
