using System;
namespace Name_war
{
    class Program
    {
        static void Main()
        {
            string name = Console.ReadLine();
            int max = Int32.MinValue;
            string maxName = "";

            while(name != "STOP")
            {
                int sumLetters = 0;
                for (int i = 0; i < name.Length; i++)
                {
                    char currentSymbol = name[i];
                    sumLetters += (int)currentSymbol;
                }

                if(sumLetters > max)
                {
                    max = sumLetters;
                    maxName = name;
                }

                name = Console.ReadLine();
                sumLetters = 0;
            }
            Console.WriteLine($"Winner is {maxName} - {max}!");
        }
    }
}
