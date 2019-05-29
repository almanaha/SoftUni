using System;
namespace _1.Trekking_equipment
{
    class Program
    {
        static void Main()
        {
            int countClimber = int.Parse(Console.ReadLine());
            int countCarabiners = int.Parse(Console.ReadLine());
            int countRopes = int.Parse(Console.ReadLine());
            int countPickels = int.Parse(Console.ReadLine());

            double carabiners = countCarabiners * 36;
            double ropes = countRopes * 3.60;
            double pickels = countPickels * 19.80;

            double totalForOneClimber = carabiners + ropes + pickels;
            double totalForAllClimbers = totalForOneClimber * countClimber;
            double afterTaxes = totalForAllClimbers + (totalForAllClimbers * 0.20);

            Console.WriteLine($"{afterTaxes:F2}");
        }
    }
}
