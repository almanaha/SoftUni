using System;
class Program
{
    static void Main()
    {
        int vineYard = int.Parse(Console.ReadLine()); // cubic meters
        double grape = double.Parse(Console.ReadLine()); // for 1 cubic meter
        int wine = int.Parse(Console.ReadLine()); // liters needed
        int workers = int.Parse(Console.ReadLine());

        double vineForWine = vineYard * 0.40;
        double totalGrapes = vineForWine * grape;
        double totalWine = totalGrapes / 2.5;

        if (totalWine < wine)
        {
            Console.WriteLine($"It will be a tough winter! More {Math.Floor(wine - totalWine)} liters wine needed.");
        }
        else
        {
            double letfLiters = Math.Round(totalWine - wine);
            double winePerPerson = Math.Round(letfLiters / workers);
            Console.WriteLine($"Good harvest this year! Total wine: {totalWine} liters.");
            Console.WriteLine($"{letfLiters} liters left -> {winePerPerson} liters per person.");
        }

    }
}

