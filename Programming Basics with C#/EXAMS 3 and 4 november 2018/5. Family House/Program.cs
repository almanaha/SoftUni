using System;
namespace _5.Family_House
{
    class Program
    {
        static void Main()
        {
            int months = int.Parse(Console.ReadLine());
            double electricityPerMonth = double.Parse(Console.ReadLine());

            double totalElectricity = 0;
            double totalOthers = 0;

            double totalWater = months * 20;
            double totalWifi = months * 15;
            double otherExpenses = 0;

            for (int i = 1; i < months; i++)
            {
                if (i == 1)
                {
                    totalElectricity += electricityPerMonth;
                    otherExpenses = (electricityPerMonth + 20 + 15);
                    totalOthers += otherExpenses + (otherExpenses * 0.2);
                }

                electricityPerMonth = double.Parse(Console.ReadLine());
                totalElectricity += electricityPerMonth;
                otherExpenses = (electricityPerMonth + 20 + 15);

                totalOthers += otherExpenses + (otherExpenses * 0.2);
            }

            double avgPerMonth = (totalElectricity + totalWater + totalWifi + totalOthers) / months;

            Console.WriteLine($"Electricity: {totalElectricity:F2} lv");
            Console.WriteLine($"Water: {totalWater:F2} lv");
            Console.WriteLine($"Internet: {totalWifi:F2} lv");
            Console.WriteLine($"Other: {totalOthers:F2} lv");
            Console.WriteLine($"Average: {avgPerMonth:F2} lv");
        }
    }
}
