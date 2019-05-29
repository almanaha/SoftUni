using System;
using System.Linq;

namespace _2._Rotate_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr1 = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int rotation = int.Parse(Console.ReadLine());

            int[] sumArr = new int[arr1.Length];

            for (int i = 0; i < rotation; i++)
            {
                //RotateArr(arr1);
                int lastElement = arr1[arr1.Length - 1];

                for (int j = arr1.Length - 1; j > 0; j--) // rotation 
                {
                    arr1[j] = arr1[j - 1]; // changing last index with previous
                }
                arr1[0] = lastElement;

                for (int g = 0; g < arr1.Length; g++) // sum after rotation
                {
                    sumArr[g] += arr1[g];
                }
            }
            Console.WriteLine(string.Join(" ",sumArr));
        }

        //private static void RotateArr(int[] arr1)
        //{
        //    int lastElement = arr1[arr1.Length - 1];

        //    for (int i = arr1.Length - 1; i > 0; i--) // without index 0 , because its re-written with last index
        //    {
        //        arr1[i] = arr1[i - 1];
        //    }
        //    arr1[0] = lastElement;
        //}
    }
}
