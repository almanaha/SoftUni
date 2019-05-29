using System;
namespace _6.Wedding_Seats
{
    class Program
    {
        static void Main()
        {
            char sector = char.Parse(Console.ReadLine());
            int rows = int.Parse(Console.ReadLine());
            int seats = int.Parse(Console.ReadLine());
            int counter = 0;

            for (char i = 'A'; i <= sector; i++)
            {
                for (int i2 = 1; i2 <= rows; i2++)
                {
                    if (i2 % 2 == 1)
                    {
                        for (int i3 = 1; i3 <= seats; i3++)
                        {
                            Console.WriteLine($"{i}{i2}{(char)(i3+96)}");
                            counter++;
                        }
                    }
                    else if(i2 % 2 == 0)
                    {
                        for (int i3 = 1; i3 <= seats + 2; i3++)
                        {
                            Console.WriteLine($"{i}{i2}{(char)(i3 + 96)}");
                            counter++;
                        }
                    }
                }
                rows++;
            }
            Console.WriteLine(counter);
        }
    }
}
