using System;
class Program
{
    static void Main()
    {
        for (string star = "*"; star.Length <= 10; star += "*")
        {
            Console.WriteLine(star);
        }
    }
}

