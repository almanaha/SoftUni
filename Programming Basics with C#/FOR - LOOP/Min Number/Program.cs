using System;
namespace Min_Number
{
    class Program
    {
        static void Main()
        {
            int a = int.Parse(Console.ReadLine());
            double minNumber = double.MaxValue;

            for (int i = 0; i < a; i++)
            {
                double n = double.Parse(Console.ReadLine());
                if (n < minNumber)
                {
                    minNumber = n;
                }
            }
            Console.WriteLine(minNumber);
        }
    }
}
