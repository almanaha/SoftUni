using System;
namespace _3.Vacation
{
    class Program
    {
        static void Main()
        {
            int people = int.Parse(Console.ReadLine());
            string group = Console.ReadLine();
            string day = Console.ReadLine();

            double price = 0;

            switch (group)
            {
                case "Students":
                    switch (day)
                    {
                        case "Friday": price = 8.45; break;
                        case "Saturday": price = 9.80; break;
                        case "Sunday": price = 10.46; break;
                        default:
                            break;
                    }break;
                case "Business":
                    switch (day)
                    {
                        case "Friday": price = 10.90; break;
                        case "Saturday": price = 15.60; break;
                        case "Sunday": price = 16; break;
                        default:
                            break;
                    } break;
                case "Regular":
                    switch (day)
                    {
                        case "Friday": price = 15; break;
                        case "Saturday": price = 20; break;
                        case "Sunday": price = 22.50; break;
                        default:
                            break;
                    }break;
            }

            double totalSum = people * price;

            if (group == "Students" && people >= 30)
            {
                totalSum *= 0.85;
            }
            else if (group == "Business" && people >= 100)
            {
                totalSum *= 0.90;
            }
            else if (group == "Regular" && people >= 10 && people <= 20)
            {
                totalSum *= 0.95;
            }

            Console.WriteLine($"Total price: {totalSum:F2}");
        }
    }
}
