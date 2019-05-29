using System;

class CarTOGO
{
    static void Main()
    {
        var budget = double.Parse(Console.ReadLine());
        string season = Console.ReadLine();

        string carClass = string.Empty;
        string carType = string.Empty;
        double moneyForCar = 0;

        if (budget <= 100)
        {
            carClass = "Economy class";

            if (season == "Summer")
            {
                carType = "Cabrio";
                moneyForCar = budget * 0.35;
            }
            else if (season == "Winter")
            {
                carType = "Jeep";
                moneyForCar = budget * 0.65;
            }
        }
        else if (budget > 100 && budget <= 500)
        {
            carClass = "Compact class";

            if (season == "Summer")
            {
                carType = "Cabrio";
                moneyForCar = budget * 0.45;
            }
            else if (season == "Winter")
            {
                carType = "Jeep";
                moneyForCar = budget * 0.8;
            }
        }
        else if (budget > 500)
        {
            carClass = "Luxury class";

            if (season == "Summer")
            {
                carType = "Cabrio";
                moneyForCar = budget * 0.9;
            }
            else if (season == "Winter")
            {
                carType = "Jeep";
                moneyForCar = budget * 0.9;
            }
        }
        Console.WriteLine(carClass);
        Console.WriteLine($"{carType} - {moneyForCar:F2}");
    }
}

