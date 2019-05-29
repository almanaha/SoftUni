using System;
namespace Letter_combination
{
    class Program
    {
        static void Main()
        {
            char start = char.Parse(Console.ReadLine());
            char end = char.Parse(Console.ReadLine());
            char skip = char.Parse(Console.ReadLine());
            int counter = 0;

            for (char first = start;first <= end;first++)
            {
                for (char second = start; second <= end; second++)
                {
                    for (char third = start; third <= end; third++)
                    {
                        if (first != skip && second != skip && third != skip)
                        {
                            Console.Write($"{first}{second}{third} ");
                            counter++;
                        }
                    }
                }
            }
            Console.Write(counter + " ");
        }
    }
}
