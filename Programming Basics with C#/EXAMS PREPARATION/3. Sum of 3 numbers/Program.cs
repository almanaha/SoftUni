﻿using System;
class Program
{
    static void Main()
    {
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());
        int c = int.Parse(Console.ReadLine());

        if (a + b == c)
        {
            Console.WriteLine($"{a} + {b} = {c}");
        }
        else
        {
            Console.WriteLine("No");
        }
    }
}

