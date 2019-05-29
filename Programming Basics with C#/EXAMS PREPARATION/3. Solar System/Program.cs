using System;
class Program
{
    static void Main()
    {
        string planet = Console.ReadLine();
        int days = int.Parse(Console.ReadLine());

        double distance = 0;
        double totalDays = 0;

        switch (planet)
        {
            case "Mercury":
                if (days <= 7)
                {
                    distance = 0.61 * 2; totalDays = 226 * distance + days;
                }
                else
                {
                    Console.WriteLine("Invalid number of days!");
                }break;
            case "Venus":
                if (days <= 14)
                {
                    distance = 0.28 * 2; totalDays = 226 * distance + days;
                }
                else
                {
                    Console.WriteLine("Invalid number of days!");
                }break; 
            case "Mars":
                if (days <= 20)
                {
                    distance = 0.52 * 2; totalDays = 226 * distance + days;
                }
                else
                {
                    Console.WriteLine("Invalid number of days!");
                } break;
            case "Jupiter":
                if (days <= 5)
                {
                    distance = 4.2 * 2; totalDays = 226 * distance + days;
                }
                else
                {
                    Console.WriteLine("Invalid number of days!");
                }break;
            case "Saturn":
                if (days <= 3)
                {
                    distance = 8.52 * 2; totalDays = 226 * distance + days;
                }
                else
                {
                    Console.WriteLine("Invalid number of days!");
                } break;
            case "Uranus":
                if (days <= 3)
                {
                    distance = 18.21 * 2; totalDays = 226 * distance + days;
                }
                else
                {
                    Console.WriteLine("Invalid number of days!");
                }break;
            case "Neptune":
                if (days <= 2)
                {
                    distance = 29.09 * 2; totalDays = 226 * distance + days;
                }
                else
                {
                    Console.WriteLine("Invalid number of days!");
                }break;
            default: Console.WriteLine("Invalid planet name"); break;
        }

        if(distance > 0)
        {
            Console.WriteLine($"Distance: {distance:F2}");
            Console.WriteLine($"Total number of days: {totalDays:F2}");
        }
    }
}

