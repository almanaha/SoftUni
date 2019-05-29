using System;
namespace Greatest_Common_Divisor__CGD_
{
    class Program
    {
        static void Main()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            if (a != b)
            {
                while ((a != 0) && (b != 0))
                {
                    int newNumber = a;
                    a = a % b;
                    b = b % newNumber;
                }
                if (a == 0)
                {
                    Console.WriteLine(b);
                }
                else
                {
                    Console.WriteLine(a);
                }
            }
            else
            {
                Console.WriteLine(a);
            }
        }
    }
}
