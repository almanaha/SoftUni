using System;
namespace _11.Multiplication_Table_2._0
{
    class Program
    {
        static void Main()
        {
            var number = int.Parse(Console.ReadLine());
            var number2 = int.Parse(Console.ReadLine());
            if (number2 > 10)
            {
                Console.WriteLine($"{number} X {number2} = {number * number2}");
            }
            else
            {
                for (int i = number2; i <= 10; i++)
                {
                    Console.WriteLine($"{number} X {i} = {number * i}");
                }
            }
        }
    }
}
