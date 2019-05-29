using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Threebrothers
{
    class Program
    {
        static void Main(string[] args)
        {
            double A = double.Parse(Console.ReadLine());
            double B = double.Parse(Console.ReadLine());
            double C = double.Parse(Console.ReadLine());
            double D = double.Parse(Console.ReadLine());

            double totalTime = 1 / (1 / A + 1 / B + 1 / C);
            double totalTimeWithRest = totalTime * 1.15;

            double leftTime = D - totalTimeWithRest;
            double notEnoughTime = totalTimeWithRest - D;

            Console.WriteLine($"Cleaning time: {totalTimeWithRest:f2}");

            if (leftTime >= 0)
            {
                Console.WriteLine($"Yes, there is a surprise - time left -> {Math.Floor(leftTime)} hours.");
            }
            else
            {
                Console.WriteLine($"No, there isn't a surprise - shortage of time -> {Math.Ceiling(notEnoughTime)} hours.");
            }
        }
    }
}
