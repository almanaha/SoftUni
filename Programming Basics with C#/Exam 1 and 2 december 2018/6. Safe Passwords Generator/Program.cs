using System;

namespace _06._Safe_Passwords_Generator
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int maxPas = int.Parse(Console.ReadLine());
            int counterMaxPas = 0;
            int A = 35;
            int B = 64;

            for (int x = 1; x <= a; x++)
            {
                for (int y = 1; y <= b; y++)
                {
                    if (x <= a && y <= b && counterMaxPas < maxPas)
                    {
                        Console.Write("" + (char)A + (char)B + x + y + (char)B + (char)A + "|");
                        counterMaxPas++;
                    }
                    if (A >= 55){ A = 35;}
                    else { A += 1; }
                    if (B >= 96)  {  B = 64; }
                    else { B += 1; }
                }
            }
        }
    }
}
