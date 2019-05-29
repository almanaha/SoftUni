using System;
namespace _1.Sea_Trip
{
    class Program
    {
        static void Main()
        {
            double moneyFood = double.Parse(Console.ReadLine());
            double moneySouvenir = double.Parse(Console.ReadLine());
            double moneyHotel = double.Parse(Console.ReadLine());

            double days = 3;
            double total = 0;

            double gasoline = 29.4;
            double moneyGasoline = gasoline * 1.85;
            double moneyFoodSouvenirs = days * moneyFood + days * moneySouvenir;

            double day1 = moneyHotel * 0.9;
            double day2 = moneyHotel * 0.85;
            double day3 = moneyHotel * 0.8;

            total = moneyGasoline + moneyFoodSouvenirs + day1 + day2 + day3;

            Console.WriteLine($"Money needed: {total:F2}");
        }
    }
}
