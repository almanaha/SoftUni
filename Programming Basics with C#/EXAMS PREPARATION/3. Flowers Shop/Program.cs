using System;
namespace _3.Flowers_Shop
{
    class Program
    {
        static void Main()
        {
            double countOfChrysanthemums = double.Parse(Console.ReadLine());
            double countOfRoses = double.Parse(Console.ReadLine());
            double countOfTulips = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();
            string holiday = Console.ReadLine();

            double totalFlowers = countOfChrysanthemums + countOfRoses + countOfTulips;

            double chrysanthemums = 0;
            double roses = 0;
            double tulips = 0;

            if (season == "Summer" || season == "Spring")
            {
                chrysanthemums = countOfChrysanthemums * 2.00;
                roses = countOfRoses * 4.10;
                tulips = countOfTulips * 2.50;

            }
            else if (season == "Winter" || season == "Autumn")
            {
                chrysanthemums = countOfChrysanthemums * 3.75;
                roses = countOfRoses * 4.50;
                tulips = countOfTulips * 4.15;
            }
            double priceForBouquet = chrysanthemums + roses + tulips;

            if (holiday == "Y")
            {
                priceForBouquet *= 1.15;
            }

            if (countOfTulips > 7 && season == "Spring")
            {
                priceForBouquet *= 0.95;
            }
            if (countOfRoses >= 10 && season == "Winter")
            {
                priceForBouquet *= 0.9;
            }
            if (totalFlowers > 20)
            {
                priceForBouquet *= 0.8;
            }

            priceForBouquet += 2;

            Console.WriteLine($"{priceForBouquet:F2}");

        }
    }
}
