using System;
namespace Coding
{
    class Program
    {
        static void Main()
        {
            string input = Console.ReadLine();
            for (int i = input.Length - 1; i >= 0; i--)
            {
                string empty = "";
                string charToString = empty + input[i];
                int num = int.Parse(charToString);

                if (num == 0)
                {
                    Console.WriteLine("ZERO");
                    continue;
                }
                for (int m = 0; m < num; m++)
                {
                    Console.Write((char)(num + 33));
                }
                Console.WriteLine();

            }
        }
    }
}
