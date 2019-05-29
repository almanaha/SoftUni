using System;
namespace _3.Computer_Room
{
    class Program
    {
        static void Main()
        {
            string month = Console.ReadLine().ToLower(); ;
            int hours = int.Parse(Console.ReadLine());
            int people = int.Parse(Console.ReadLine());
            string timeOfDay = Console.ReadLine();
            double money = 0;

            if (month == "march" || month == "april" || month == "may")
            {
                if (timeOfDay == "day")
                {
                    money = 10.50;
                }
                else if (timeOfDay == "night")
                {
                    money = 8.4;
                }
            }
            else if (month == "june" || month == "july" || month == "august")
            {
                if (timeOfDay == "day")
                {
                    money = 12.60;
                }
                else if(timeOfDay == "night")
                {
                    money = 10.20;
                }
            }

            if (people >= 4)
            {
                money -= money * 0.1;
            }

            if (hours >= 5)
            {
                money -= money * 0.5;
            }

            double totalCost = (money * hours) * people;

            Console.WriteLine($"Price per person for one hour: {money:F2}");
            Console.WriteLine($"Total cost of the visit: {totalCost:F2}");
        }
    }
}
