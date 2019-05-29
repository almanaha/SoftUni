﻿using System;
namespace _6.Digits
{
    class Program
    {
        static void Main()
        {
            int number = int.Parse(Console.ReadLine());

            int thirdDigit = number % 10;
            int secondDigit = (number / 10) % 10;
            int firstDigit = number / 100;

            int rows = firstDigit + secondDigit;
            int cols = firstDigit + thirdDigit;

            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    if (number % 5 == 0)
                    {
                        number -= firstDigit;
                    }
                    else if (number % 3 ==0)
                    {
                        number -= secondDigit;
                    }
                    else
                    {
                        number += thirdDigit;
                    }

                    Console.Write($"{number} ");
                }
                Console.WriteLine();
            }
        }
    }
}
