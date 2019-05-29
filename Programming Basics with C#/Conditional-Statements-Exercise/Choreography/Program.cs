using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Choreography
{
    class Program
    {
        static void Main(string[] args)
        {
            double countOfSteps = double.Parse(Console.ReadLine());
            double dancers = double.Parse(Console.ReadLine());
            double daysForLearning = double.Parse(Console.ReadLine());

            double stepsPerDay = Math.Ceiling(1 * 100 / daysForLearning);

            double stepsForDancer = stepsPerDay / dancers;

            if (stepsPerDay <= 13)
            {
                Console.WriteLine($"Yes, They will succeed in that goal! {stepsForDancer:f2}%.");
            }
            else
            {
                Console.WriteLine($"No, They will not succeed in that goal! Required {stepsForDancer:F2}% steps to be learned per day.");
            }
        }
    }
}