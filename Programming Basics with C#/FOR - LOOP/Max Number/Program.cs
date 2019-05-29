using System;
namespace Max_Number
{
    class Program
    {
        static void Main()
        {
            int a = int.Parse(Console.ReadLine());
            double maxNumber = double.MinValue;

            for (int i = 0; i < a; i++)
            {
                double n = double.Parse(Console.ReadLine());
                if (n > maxNumber)
                {
                    maxNumber = n;
                }
            }
            Console.WriteLine(maxNumber);
        }
    }
}
