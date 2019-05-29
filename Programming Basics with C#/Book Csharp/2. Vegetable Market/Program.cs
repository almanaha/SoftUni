using System;
class Program
{
    static void Main()
    {
        double vegetables = double.Parse(Console.ReadLine()); // for 1 kg
        double fruits = double.Parse(Console.ReadLine()); // for 1 kg
        double totalVegetables = double.Parse(Console.ReadLine()); // in kg
        double totalFruits = double.Parse(Console.ReadLine()); // in kg

        double sumVeg = (vegetables * totalVegetables);
        double sumFruits = (fruits * totalFruits);
        double sumEuro = (sumVeg + sumFruits) / 1.94;

        Console.WriteLine(sumEuro);
    }
}

