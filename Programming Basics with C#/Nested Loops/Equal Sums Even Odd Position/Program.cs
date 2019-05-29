using System;
namespace Equal_Sums_Even_Odd_Position
{
    class Program
    {
        static void Main()
        {
            int firstNumber = int.Parse(Console.ReadLine());
            int secondNumber = int.Parse(Console.ReadLine());

            for (int i = firstNumber; i <= secondNumber; i++)
            {
                string num = i.ToString();
                int lenght = num.Length;

                int evenSum = 0;
                int oddSum = 0;
                int process = i;

                for (int k = 0; k < lenght; k++)
                {
                    int modul = process % 10;
                    if (k % 2 != 0)
                    {
                        evenSum += modul;
                    }
                    else
                    {
                        oddSum += modul;
                    }

                    process = process / 10;
                }

                if (oddSum == evenSum)
                {
                    Console.Write(i + " ");
                }
            }
        }
    }
}
