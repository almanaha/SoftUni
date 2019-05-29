using System;

namespace Increasing4Numbers
{
    class Increasing4Numbers
    {
        static int A, B;
        const int N = 4;
        static int[] arr = new int[N];

        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine()),
                b = int.Parse(Console.ReadLine());

            if (b - a < N - 1)
            {
                Console.WriteLine("No");
                return;
            }
            A = a;
            B = b;
            GenerateVariations(0, A);
        }

        static void GenerateVariations(int index, int value)
        {
            if (index == N)
                PrintArray();
            else
                for (int i = value; i <= B; i++)
                {
                    arr[index] = i;
                    GenerateVariations(index + 1, i + 1);
                }
        }

        static void PrintArray()
        {
            Console.WriteLine(string.Join(" ", arr));
        }
    }
}
