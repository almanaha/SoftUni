using System;
class Program
{
    static void Main()
    {
        int x1 = int.Parse(Console.ReadLine());
        int x2 = int.Parse(Console.ReadLine());
        int y1 = int.Parse(Console.ReadLine());
        int y2 = int.Parse(Console.ReadLine());

        int counter = 0;

        for (int num1 = x1; num1 <= 8; num1++) // x1 ... 8
        {
            for (int num2 = 9; num2 >= x2; num2--) // 9 .. x2
            {
                for (int num3 = y1; num3 <= 8; num3++) // y1 .. 8
                {
                    for (int num4 = 9; num4 >= y2; num4--) // 9 .. y2
                    {
                        if (num1 % 2 == 0 && num2 % 2 == 1 &&
                            num3 % 2 == 0 && num4 % 2 == 1)
                        {
                            if (counter >= 6)
                            {
                                return;
                            }
                            else if (num1 == num3 && num2 == num4)
                            {
                                Console.WriteLine("Cannot change the same player.");
                            }
                            else
                            {
                                Console.WriteLine($"{num1}{num2} - {num3}{num4}");
                                counter++;
                            }
                        }
                    }
                }
            }
        }
    }
}

