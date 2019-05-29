using System;
namespace _9.Padawan_Equipment
{
    class Program
    {
        static void Main()
        {
            decimal totalMoney = decimal.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());

            decimal lightsabers = decimal.Parse(Console.ReadLine());
            decimal ropes = decimal.Parse(Console.ReadLine());
            decimal belts = decimal.Parse(Console.ReadLine());

            decimal sabersPrice = lightsabers * Math.Ceiling(students * 1.1m);
            decimal ropesPrice = ropes * students;

            int beltsLeft = students % 6;
            int beltsCount = students / 6 * 5 + beltsLeft;
            decimal beltsPrice = beltsCount * belts;

            decimal totalSpentMoney = sabersPrice + ropesPrice + beltsPrice;

            if (totalSpentMoney <= totalMoney)
            {
                Console.WriteLine($"The money is enough - it would cost {totalSpentMoney:F2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivan Cho will need {(totalSpentMoney-totalMoney):F2}lv more.");
            }
        }
    }
}
