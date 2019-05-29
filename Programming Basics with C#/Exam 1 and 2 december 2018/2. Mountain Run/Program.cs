using System;
namespace _2.Mountain_Run
{
    class Program
    {
        static void Main()
        {
            double record = double.Parse(Console.ReadLine()); // in seconds
            double distance = double.Parse(Console.ReadLine()); // in meters
            double seconds = double.Parse(Console.ReadLine()); // for 1 meter

            double totalSec = distance * seconds;
            double extraSec = Math.Floor(distance / 50) * 30; //На всеки 50 м. към времето му се добавят 30 сек
            double totalTime = totalSec + extraSec;

            if (totalTime < record)
            {
                Console.WriteLine($"Yes! The new record is {totalTime:F2} seconds.");
            }
            else
            {
                Console.WriteLine($"No! He was {totalTime-record:F2} seconds slower.");
            }

        }
    }
}
