using System;
using System.Linq;

namespace _9._Jump_Around
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int index = 0;
            long sum = 0L;

            while (true)
            {
                int tempIndex = index;
                sum += numbers[index];
                index += numbers[index];
                if (index > numbers.Length - 1)
                {
                    index =  tempIndex - numbers[tempIndex];
                    if (index < 0)
                    {
                        break;
                    }
                }
            }
            Console.WriteLine(sum);
        }
    }
}
