using System;
namespace Fan_Shop
{
    class Program
    {
        static void Main()
        {
            int budget = int.Parse(Console.ReadLine());
            int itemsCount = int.Parse(Console.ReadLine());

            for (int currentItem = 0; currentItem < itemsCount; currentItem++)
            {
                string itemType = Console.ReadLine();

                switch (itemType)
                {
                    case "hoodie": budget -= 30; break;
                    case "keychain": budget -= 4; break;
                    case "T-shirt": budget -= 20; break;
                    case "flag": budget -= 15; break;
                    case "sticker": budget -= 1; break;
                }
            }

            if (budget >= 0)
            {
                Console.WriteLine($"You bought {itemsCount} items and left with {budget} lv.");
            }
            else
            {
                Console.WriteLine($"Not enough money, you need {Math.Abs(budget)} more lv.");
                // {budget * -1}
            }
        }
    }
}
