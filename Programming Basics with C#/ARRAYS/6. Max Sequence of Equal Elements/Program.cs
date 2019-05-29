using System;
using System.Linq;

namespace _6._Max_Sequence_of_Equal_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int bestIndex = 0;
            int bestLenght = 1;

            int currentIndex = 0;
            int currentLenght = 0;

            for (int i = 1; i < arr.Length; i++)
            {
                if (arr[i] == arr[i - 1])
                {
                    currentLenght++;

                    if (currentLenght > bestLenght)
                    {
                        bestLenght = currentLenght;
                        bestIndex = currentIndex;
                    }
                }
                else
                {
                    currentIndex = i;
                    currentLenght = 1;
                }

            }
            for (int i = bestIndex; i < bestIndex + bestLenght; i++)
            {
                Console.Write(arr[i] + " ");
            }
        }
    }
}
