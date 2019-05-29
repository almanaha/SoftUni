using System;
class Program
{
    static void Main()
    {
        int coin1 = int.Parse(Console.ReadLine());
        int coin2 = int.Parse(Console.ReadLine());
        int coin5 = int.Parse(Console.ReadLine());
        int money = int.Parse(Console.ReadLine());

        for (int c1 = 0; c1 <= coin1; c1++)
        {
            for (int c2 = 0; c2 <= coin2; c2++)
            {
                for (int c3 = 0; c3 <= coin5; c3++)
                {
                    int totalMoney = (c1 * 1) + (c2 * 2) + (c3 * 5);

                    if (totalMoney == money)
                    {
                        Console.WriteLine($"{c1} * 1 lv. + {c2} * 2 lv. + {c3} * 5 lv. = {money} lv.");
                    }
                }
            }
        }
    }
}

