using System;
namespace _2.New_Year_Party
{
    class Program
    {
        static void Main()
        {
            int guests = int.Parse(Console.ReadLine());
            int budget = int.Parse(Console.ReadLine());

            double couvert = guests * 20;
            double moneyLeft = Math.Abs(budget - couvert);

            if (moneyLeft < 0)
            {
                Console.WriteLine($"They won`t have enough money to pay the covert. They will need {moneyLeft}");
            }
            else
            {
                double fireworks = moneyLeft * 0.4;
                double donation = moneyLeft * 0.6; ;
                Console.WriteLine($"Yes! {fireworks} lv are for fireworks and {donation} are for donation.");
            }
        }
    }
}
