using System;

class Strongnumber
{
    static void Main()
    {
        int number = int.Parse(Console.ReadLine());
        int numberCopy = number;
        int sumFactorial = 0;

        while (number != 0)
        {
            int currentNumber = number % 10; // за да вземем остатъка (145 - 5)
            number /= 10;

            int factorial = 1;

            for (int i = 1; i <= currentNumber; i++)
            {
                factorial *= i;
            }

            sumFactorial += factorial;
        }
        if (sumFactorial == numberCopy)
        {
            Console.WriteLine("yes");
        }
        else
        {
            Console.WriteLine("no");
        }
    }
}

