using System;
namespace _4.Running_In_The_Park
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            int mins = 0;
            double ranDistance = 0;
            int calories = 0;

            for (int i = 0; i < n; i++)
            {
                int time = int.Parse(Console.ReadLine());
                mins += time;
                double distance = double.Parse(Console.ReadLine());
                string unit = Console.ReadLine();

                if (unit == "km")
                    distance *= 1;
                else if (unit == "m")
                    distance *= 0.001;

                ranDistance += distance;
                calories += time * 400 / 20;
            }

            Console.WriteLine($"He ran {ranDistance:f2}km for {mins} minutes and burned {calories} calories.");
        }
    }
}
