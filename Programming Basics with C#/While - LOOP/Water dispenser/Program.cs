using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GlassOfWater
{
    class Program
    {
        static void Main(string[] args)
        {
            double volume = double.Parse(Console.ReadLine());
            double counterOfTimes = 0;
            double counterOfMililiters = 0;

            while (volume > 0)
            {
                string mililiters = Console.ReadLine();

                if (mililiters == "Easy")
                {
                    counterOfTimes++;
                    counterOfMililiters += 50;
                }
                else if (mililiters == "Medium")
                {
                    counterOfTimes++;
                    counterOfMililiters += 100;
                }
                else if (mililiters == "Hard")
                {
                    counterOfTimes++;
                    counterOfMililiters += 200;
                }

                if (volume == counterOfMililiters)
                {
                    Console.WriteLine($"The dispenser has been tapped {counterOfTimes} times.");
                    break;
                }
                else if (volume < counterOfMililiters)
                {
                    double differenceSpillage = counterOfMililiters - volume;
                    Console.WriteLine($"{differenceSpillage}ml has been spilled.");
                    break;
                }
            }
        }
    }
}
