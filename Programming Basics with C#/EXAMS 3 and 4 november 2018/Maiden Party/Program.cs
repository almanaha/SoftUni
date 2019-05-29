using System;
namespace Maiden_Party
{
    class Program
    {
        static void Main()
        {
            double partyMoney = double.Parse(Console.ReadLine());
            int loveMessages = int.Parse(Console.ReadLine());
            int waxRoses = int.Parse(Console.ReadLine());
            int keychains = int.Parse(Console.ReadLine());
            int cartoons = int.Parse(Console.ReadLine());
            int luckySuprises = int.Parse(Console.ReadLine());

            double loveMessagesPrice = loveMessages * 0.60;
            double waxRosesPrice = waxRoses * 7.2;
            double keychainsPrice = keychains * 3.60;
            double cartoonsPrice = cartoons * 18.20;
            double luckySuprisesPrice = luckySuprises * 22;
            double discount = 0;
            int totalSum = loveMessages + waxRoses + keychains + cartoons + luckySuprises;
            double totalMoneyForArticles = loveMessagesPrice + waxRosesPrice + keychainsPrice + cartoonsPrice + luckySuprisesPrice;

            if (totalSum >= 25)
            {
                discount = totalMoneyForArticles * 0.35;
            }

            double lastSum = totalMoneyForArticles - discount;
            double hostingMoney = lastSum * 0.1;
            double profit = lastSum - hostingMoney;

            if (profit >= partyMoney)
            {
                double party = profit - partyMoney;
                Console.WriteLine($"Yes! {party:F2} lv left.");
            }
            else
            {
                double party = partyMoney - profit;
                Console.WriteLine($"Not enough money! {party:F2} lv needed.");
            }


        }
    }
}
