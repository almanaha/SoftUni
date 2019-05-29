using System;
class Program
{
    static void Main()
    {
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());
        int maxPasswords = int.Parse(Console.ReadLine());

        char A = (char)35;
        char B = (char)64;
        int passwords = 0;

        for (int i = 1; i <= a; i++)
        {
            for (int g = 1; g <= b; g++)
            {
                if (passwords == maxPasswords)
                {
                    return;
                }
                if (A > 55)
                {
                    A = (char)35;
                }
                if (B > 96)
                {
                    B = (char)64;
                }

                Console.Write($"{A}{B}{i}{g}{B}{A}|");
                A++;
                B++;
                passwords++;
            }
        }
    }
}

