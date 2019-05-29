using System;
namespace _3.Ski_Trip
{
    class Program
    {
        static void Main()
        {
            int days = int.Parse(Console.ReadLine());
            string rooms = Console.ReadLine();
            string rating = Console.ReadLine();

            int totalNights = days - 1;
            double totalSum = 0;
            double pricePerRoom = 0;

            switch (rooms)
            {
                case "room for one person": pricePerRoom = 18.00;
                    totalSum = pricePerRoom * totalNights;
                    break;
                case "apartment": pricePerRoom = 25.00;
                    totalSum = pricePerRoom * totalNights;
                    if (totalNights < 10)
                    {
                        totalSum *= 0.7;
                    }
                    else if (totalNights >= 10 && totalNights <= 15)
                    {
                        totalSum *= 0.65;
                    }
                    else if (totalNights > 15)
                    {
                        totalSum *= 0.95;
                    }break;

                case "president apartment": pricePerRoom = 35.00;
                    totalSum = pricePerRoom * totalNights;

                    if (totalNights < 10)
                    {
                        totalSum *= 0.9;
                    }
                    else if (totalNights >= 10 && totalNights <= 15)
                    {
                        totalSum *= 0.85;
                    }
                    else if (totalNights > 15)
                    {
                        totalSum *= 0.8;
                    }break;
            }

            if (rating == "positive")
            {
                totalSum += totalSum * 0.25;
            }
            else if(rating == "negative")
            {
                totalSum -= totalSum * 0.1;
            }

            Console.WriteLine($"{totalSum:F2}");

        }
    }
}
