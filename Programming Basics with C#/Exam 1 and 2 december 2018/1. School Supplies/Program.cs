using System;
namespace _1.School_Supplies
{
    class Program
    {
        static void Main()
        {
            int countPencils = int.Parse(Console.ReadLine());
            int countMarkers = int.Parse(Console.ReadLine());
            double litersDetergent = double.Parse(Console.ReadLine());
            int discount = int.Parse(Console.ReadLine());

            double pricePencils = countPencils * 5.80;
            double priceMarkers = countMarkers * 7.20;
            double priceDetergent = litersDetergent * 1.20;
            double totalSum = pricePencils + priceMarkers + priceDetergent;
            double priceWithDiscount = totalSum - ((totalSum * discount) / 100);

            Console.WriteLine($"{priceWithDiscount:F3}");
        }
    }
}
