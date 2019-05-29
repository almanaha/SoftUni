using System;
namespace Wedding_party
{
    class Program
    {
        static void Main()
        {
            int guestCount = int.Parse(Console.ReadLine());
            int budget = int.Parse(Console.ReadLine());

            int totalCoverts = guestCount * 20;

            if (totalCoverts < budget)
            {
                int moneyLeft = budget - totalCoverts;
                double moneyForFireworks = moneyLeft * 0.6;
                double moneyForCharity = moneyLeft - moneyForFireworks;
                Console.WriteLine($"Yes! {moneyForCharity} lv are for fireworks and {moneyForFireworks} lv are for donation. ");
            }
            else
            {
                int moneyNeeded = totalCoverts - budget;
                Console.WriteLine($"They won't have enough money to pay the covert. They will need {moneyNeeded} lv more.");
            }
        }
    }
}
