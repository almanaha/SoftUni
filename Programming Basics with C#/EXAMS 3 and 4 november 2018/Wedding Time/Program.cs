using System;
namespace Wedding_Time
{
    class Program
    {
        static void Main()
        {
            double wiskeyPrice = double.Parse(Console.ReadLine());
            double waterInLitters = double.Parse(Console.ReadLine());
            double wineInLitters = double.Parse(Console.ReadLine());
            double champagneInLitters = double.Parse(Console.ReadLine());
            double wiskeyInLitters = double.Parse(Console.ReadLine());

            double champagnePrice = wiskeyPrice - (wiskeyPrice * 0.5);
            double winePrice = champagnePrice - (champagnePrice * 0.6);
            double waterPrice = champagnePrice - (champagnePrice * 0.9);

            double sumChampagne = champagneInLitters * champagnePrice;
            double sumWine = wineInLitters * winePrice;
            double sumWater = waterInLitters * waterPrice;
            double sumWiskey = wiskeyInLitters * wiskeyPrice;

            double totalSum = sumChampagne + sumWater + sumWine + sumWiskey;

            Console.WriteLine($"{totalSum:F2}");
        }
    }
}
