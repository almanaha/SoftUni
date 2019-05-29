using System;
class Program
{
    static void Main()
    {
        string month = Console.ReadLine().ToLower();
        double hours = double.Parse(Console.ReadLine());
        int people = int.Parse(Console.ReadLine());
        string timeInDay = Console.ReadLine().ToLower();

        double price = 0;

        switch (month)
        {
            
            case "march":
            case "april":
            case "may":
                if (timeInDay == "day")
                {
                    price = 10.50;
                }
                else
                {
                    price = 8.4;
                }break;
            case "june":
            case "july":
            case "august":
                if (timeInDay == "day")
                {
                    price = 12.60;
                }
                else
                {
                    price = 10.20;
                }break;
        }
        double discount = 0;
        double priceForOne = 0;
        if (people >= 4)
        {
            discount = price - (price * 0.1);
        }
        else
        {
            discount = price;
        }
        if (hours >= 5)
        {
            priceForOne = discount - (discount * 0.5);
        }
        else
        {
            priceForOne = price;
        }
        double totalSum = (priceForOne * hours) * people;

        Console.WriteLine($"Price per person for one hour: {price:F2}");
        Console.WriteLine($"Total cost of the visit: {totalSum:F2}");
        
    }
}

