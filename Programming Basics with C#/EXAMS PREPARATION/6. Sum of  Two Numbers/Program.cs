using System;
namespace _6.Sum_of__Two_magicNumbers
{
    class Program
    {
        static void Main()
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());
            int magicNumber = int.Parse(Console.ReadLine());

            bool isCombination = false;
            int counter = 0;
            int sum = 0;

            for (int i = start; i <= end; i++)
            {
                for (int g = start; g <= end; g++)
                {
                    counter++;
                    sum = i + g;
                    if (magicNumber == sum)
                    {
                        isCombination = true;
                        Console.Write($"Combination N:{counter} ");
                        Console.Write($"({i} + {g} = {sum})");
                        break;
                    }
                }
                if (magicNumber == sum)
                {
                    break;
                }
            }
            if (isCombination == false)
            {
                Console.WriteLine($"{counter} combinations - neither equals {magicNumber}");
            }
        }
    }
}
