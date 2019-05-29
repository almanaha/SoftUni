using System;
class Program
{
    static void Main()
    {
        double length = double.Parse(Console.ReadLine()); // in meters
        double width = double.Parse(Console.ReadLine()); // in meters

        double lengthInSm = length * 100;
        double widthInSm = (width * 100) - 100; // 100 sm for corridor

        double rows = Math.Floor(lengthInSm / 120);
        double workSpace = Math.Floor(widthInSm / 70); // offices/tables

        int totalPlaces = (int)rows * (int)workSpace - 3;
        Console.WriteLine(totalPlaces);


        
    }
}

