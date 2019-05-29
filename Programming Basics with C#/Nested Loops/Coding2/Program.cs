using System;
namespace Coding2
{
    class Program
    {
        static void Main(string[] args)
        {
            int inputNum = int.Parse(Console.ReadLine());

            string inputNumToString = inputNum.ToString();
            for (int i = inputNumToString.Length - 1; i >= 0; i--)
            {
                int currenDigit = inputNum % 10;
                inputNum = inputNum / 10;

                if (currenDigit == 0)
                {
                    Console.WriteLine("ZERO");
                    continue;
                }
                for (int m = 0; m  < currenDigit; m ++)
                {
                    Console.Write((char)(currenDigit + 33));
                }
                Console.WriteLine();
            }

        }
    }
}
