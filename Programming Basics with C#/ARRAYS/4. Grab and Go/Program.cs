using System;
using System.Linq;

namespace _4._Grab_and_Go
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] number = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int numToSearch = int.Parse(Console.ReadLine());
            int index = 0;
            bool isFound = false;

            for (int i = number.Length - 1; i >= 0; i--)
            {
                if (number[i] == numToSearch)
                {
                    index = i;
                    isFound = true;
                    break;
                }
            }
            long sum = 0;
            if (isFound)
            {
                for (int i = 0; i < index; i++)
                {
                    sum += number[i];
                }
                Console.WriteLine(sum);
            }
            else
            {
                Console.WriteLine("No occurences were found!");
            }

        }
    }
}
