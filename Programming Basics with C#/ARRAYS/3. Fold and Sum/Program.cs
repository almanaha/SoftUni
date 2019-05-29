using System;
using System.Linq;

namespace _3._Fold_and_Sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int k = arr.Length / 4;

            int[] leftArr = new int[k];
            int[] middleArr = new int[2 * k];
            int[] rightArr = new int[k];

            int[] result = new int[2 * k];

            for (int i = 0; i < k; i++)
            {
                leftArr[i] = arr[i]; // взимаме само (левите) стойности от целия масив
                rightArr[i] = arr[3 * k + i]; // пропускаме първите двойки(3 * к) и след това взимаме(+ i) дясната двойка
            }

            for (int i = 0; i < 2 * k; i++)
            {
                middleArr[i] = arr[k + i];
            }

            Array.Reverse(leftArr); // Метод, който приема масив като параметър.
            Array.Reverse(rightArr);

            for (int i = 0; i < k; i++)
            {
                result[i] += middleArr[i] + leftArr[i]; // result(2 * k) е само вътрешността на аrr[],след Array.Reverse събираме вече обърнатите числа със средния масив;

                result[i + k] += middleArr[i + k] + rightArr[i];
            }
            Console.WriteLine(string.Join(" ",result));

        }
    }
}
