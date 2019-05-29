using System;
namespace Number_Table
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            int current = 1;

            for (int rows = 0; rows < n; rows++)
            {
                for (int cols = 0; cols < n; cols++)
                {
                    current = rows + cols + 1;
                    if (current > n)
                    {
                        current = 2 * n - current;
                    }
                    Console.Write(current + " ");
                }
                Console.WriteLine();
            }
        }
    }
}
