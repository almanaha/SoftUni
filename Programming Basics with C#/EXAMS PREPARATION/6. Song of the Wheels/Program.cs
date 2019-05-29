using System;
namespace _6.Song_of_the_Wheels
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            string password = string.Empty;
            int counter = 0;

            for (int a = 1; a <= 9; a++)
            {
                for (int b = 1; b <= 9; b++)
                {
                    for (int c = 1; c <= 9; c++)
                    {
                        for (int d = 1; d <= 9; d++)
                        {
                            int sum = a * b + c * d;
                            if (sum == n && a < b && c > d)
                            {
                                Console.Write($"{a}{b}{c}{d} ");
                                counter++;
                                if (counter == 4)
                                {
                                    password = $"{a}{b}{c}{d} ";
                                }
                            }
                        }
                    }
                }
            }
            Console.WriteLine();
            if (password != string.Empty)
            {
                Console.WriteLine($"Password: {password}");
            }
            else
            {
                Console.WriteLine("No!");
            }
        }
    }
}
