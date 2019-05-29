using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3.Printing_Triangle
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            PrintTriangleHeader(n);
            PrintTriangleBody(n);
            PrintTriangleFooter(n);
        }

        static void PrintLine(int start, int end)
        {
            for (int i = start; i <= end; i++)
            {
                Console.Write($"{i} ");
            }
            Console.WriteLine();
        }

        static void PrintTriangleHeader(int n)
        {
            for (int i = 0; i < n; i++)
            {
                PrintLine(1, i);
            }
        }

        static void PrintTriangleBody(int n)
        {
            PrintLine(1, n);
        }

        static void PrintTriangleFooter(int n)
        {
            for (int i = n - 1; i > 0; i--)
            {
                PrintLine(1, i);
            }
        }
    }
}
