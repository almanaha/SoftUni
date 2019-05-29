using System;
namespace Equal_Sums_Left_Right_Position
{
    class Program
    {
        static void Main()
        {
            int firstNumber = int.Parse(Console.ReadLine());
            int secondNumber = int.Parse(Console.ReadLine());

            for (int i = firstNumber; i <= secondNumber; i++)
            {
                int currentNumber = i;
                int rightSum = 0;
                int midNum = 0;
                int leftSum = 0;

                for (int k = 1; k <= 5; k ++)
                {
                    if (k < 3)
                    {
                        rightSum += currentNumber % 10;
                    }
                    else if (k == 3)
                    {
                        midNum += currentNumber % 10;

                    }
                    else
                    {
                        leftSum += currentNumber % 10;
                    }
                    currentNumber /= 10;
                }

                if (leftSum == rightSum)
                {
                    Console.Write(i + " ");
                }
                else if (leftSum < rightSum)
                {
                    if (leftSum + midNum == rightSum)
                    {
                        Console.Write(i + " ");
                    }
                }
                else
                {
                    if (rightSum + midNum == leftSum)
                    {
                        Console.Write(i + " ");
                    }
                }
            }
        }
    }
}
