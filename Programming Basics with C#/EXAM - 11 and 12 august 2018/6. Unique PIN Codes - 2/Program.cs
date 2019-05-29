using System;
namespace _6.Unique_PIN_Codes
{
    class Program
    {
        static void Main()
        {
            int firstNumber = int.Parse(Console.ReadLine());
            int secondNumber = int.Parse(Console.ReadLine());
            int thirdNumber = int.Parse(Console.ReadLine());

            for (int a = 2; a <= firstNumber; a += 2)
            {
                for (int b = 2; b <= secondNumber; b += 1)
                {
                    for (int c = 2; c <= thirdNumber; c += 2)
                    {
                        if (b == 2 || b == 3 || b == 5 || b == 7)
                        {
                            Console.WriteLine($"{a} {b} {c}");
                        }
                    }
                }
            }
        }
    }
}
