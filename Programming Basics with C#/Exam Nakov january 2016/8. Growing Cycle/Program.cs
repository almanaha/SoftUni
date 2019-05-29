using System;
namespace _8.Growing_Cycle
{
    class Program
    {
        static void Main()
        {
            var n = int.Parse(Console.ReadLine());

            var lenght = 0;
            var previous = 0;
            var maxLenght = 0;

            for (int i = 1; i <= n; i++)
            {
                var num = int.Parse(Console.ReadLine());

                if ((i == 1) || (num > previous))
                {
                    lenght++;
                }
                else
                {
                    lenght = 1;
                }

                if (lenght > maxLenght)
                {
                    maxLenght = lenght;
                }
                previous = num;
            }
            Console.WriteLine(maxLenght);
        }
    }
}
