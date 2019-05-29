using System;
class Destination
{
    static void Main()
    {
        int speed = int.Parse(Console.ReadLine());
        int firstTimeInMins = int.Parse(Console.ReadLine()); // km/hour
        int secondTimeInMins = int.Parse(Console.ReadLine()); // km/hour
        int thirdTimeInMins = int.Parse(Console.ReadLine()); // km/hours

        double s2 = speed * 1.1; 
        double s3 = s2 * 0.95;

        double speed1 = speed * (firstTimeInMins / 60.0); // km to mins
        double speed2 = s2 * (secondTimeInMins / 60.0); // km to mins
        double speed3 = s3 * (thirdTimeInMins / 60.0);  // km to mins

        double totalKm = speed1 + speed2 + speed3;

        Console.WriteLine($"{totalKm:F2}");

    }
}

