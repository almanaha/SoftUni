using System;
class Program
{
    static void Main()
    {
        double budget = double.Parse(Console.ReadLine());
        string city = Console.ReadLine();
        int nights = int.Parse(Console.ReadLine());
        double price = 0;
        double discount = 0;

        if (city == "Cairo")
        {
            price += 600 + (250 * 2) * nights;
        }
        else if (city == "Paris")
        {
            price += 350 + (150 * 2) * nights;
        }
        else if (city == "Lima")
        {
            price += 850 + (400 * 2) * nights;
        }
        else if (city == "New York")
        {
            price += 650 + (300 * 2) * nights;
        }
        else if (city == "Tokyo")
        {
            price += 700 + (350 * 2) * nights;
        }

        if (nights >= 1 && nights <= 4)
        {
            if (city == "Cairo" || city == "New York")
            {
                discount = 3;
            }
        }
        else if (nights >= 5 && nights <= 9)
        {
            if (city == "Cairo" || city == "New York")
            {
                discount = 5;
            }
            else if (city == "Paris")
            {
                discount = 7;
            }
        }
        else if (nights >= 10 && nights <= 24)
        {
            if (city == "Cairo")
            {
                discount = 10;
            }
            if (city == "Paris" || city == "New York" || city == "Tokyo")
            {
                discount = 12;
            }
        }
        else if (nights >= 25 && nights <= 49)
        {
            if (city == "Cairo" || city == "Tokyo")
            {
                discount = 17;
            }
            else if (city == "Lima" || city == "New York")
            {
                discount = 19;
            }
            else if (city == "Paris")
            {
                discount = 22;
            }
        }
        else if (nights >= 50)
        {
            discount = 30;
        }
        price -= price * (discount / 100);

        if (budget >= price)
        {
            Console.WriteLine($"Yes! You have {(budget - price):f2} leva left.");
        }
        else if (budget < price)
        {
            Console.WriteLine($"Not enough money! You need {(price - budget):f2} leva.");
        }
    }
}
