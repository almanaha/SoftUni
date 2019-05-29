using System;
using System.Linq;

namespace _1._Largest_Common_End
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr1 = Console.ReadLine().Split();
            string[] arr2 = Console.ReadLine().Split();

            var leftCount = 0;
            var rightCount = 0;
            var smallerArr = Math.Min(arr1.Length, arr2.Length);

            for (int i = 0; i < smallerArr; i++)
            {
                if (arr1[i] == arr2[i])
                {
                    leftCount++;
                }
                if (arr1[arr1.Length - 1 - i] == arr2[arr2.Length - 1 - i])
                {
                    rightCount++;
                }
            }
            Console.WriteLine(Math.Max(leftCount,rightCount));
        }
    }
}
