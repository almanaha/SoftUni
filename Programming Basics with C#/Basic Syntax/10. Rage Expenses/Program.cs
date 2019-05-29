using System;

namespace ConsoleApp5
{
    class Program
    {
        static void Main(string[] args)
        {
            int lostGames = int.Parse(Console.ReadLine());
            double headSetPrice = double.Parse(Console.ReadLine());
            double mousePrice = double.Parse(Console.ReadLine());
            double keyboardPrice = double.Parse(Console.ReadLine());
            double displayPrice = double.Parse(Console.ReadLine());

            int trashedHeadSet = 0;
            int trashedMouse = 0;
            int trashedKeyboard = 0;
            int trashedDisplay = 0;
            int displayCount = 0;
            double rageExpenses = 0;

            for (int i = 1; i <= lostGames; i++)
            {
                if (i % 2 == 0)
                {
                    trashedHeadSet++;
                    //2
                }
                if (i % 3 == 0)
                {
                    trashedMouse++;
                    //1
                }
                if (i % 2 == 0 && i % 3 == 0)
                {
                    trashedKeyboard++;
                    if (trashedKeyboard % 2 == 0)
                    {
                        displayCount = 1;
                    }
                }
                if (trashedKeyboard % 2 == 0 && displayCount == 1)
                {
                    trashedDisplay++;
                    displayCount = 0;
                }
            }
            rageExpenses = (trashedHeadSet * headSetPrice)
                + (trashedMouse * mousePrice)
                + (trashedKeyboard * keyboardPrice)
                + (trashedDisplay * displayPrice);

            Console.WriteLine($"Rage expenses: {rageExpenses:F2} lv.");
        }
    }
}