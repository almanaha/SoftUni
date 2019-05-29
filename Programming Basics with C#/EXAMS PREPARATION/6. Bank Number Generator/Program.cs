using System;
namespace _6.Bank_Number_Generator
{
    class Program
    {
        static void Main()
        {
            var a = int.Parse(Console.ReadLine());
            var b = char.Parse(Console.ReadLine());
            var c = char.Parse(Console.ReadLine());
            var d = char.Parse(Console.ReadLine());
            var e = int.Parse(Console.ReadLine());
            var N = int.Parse(Console.ReadLine());

            var counter = 0;

            for (int j = a; j <= 99; j++)
            {
                for (char k = b; k <= 'Z'; k++)
                {
                    for (char l = c; l <= 'z'; l++)
                    {
                        for (char o = d; o <= 'Z'; o++)
                        {
                            for (int p = e; p >= 10; p--)
                            {
                                if (j % 10 == 2 && p % 10 == 5) { counter += 1; }

                                if (counter == N) { Console.WriteLine($"{j}{k}{l}{o}{p}"); return; }
                            }
                        }
                    }

                }
            }
        }
    }
}
