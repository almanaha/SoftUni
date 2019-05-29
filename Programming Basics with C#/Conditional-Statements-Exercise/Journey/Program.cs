using System;

namespace Journey
{
    class Program
    {
        static void Main()
        {
            double budget = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();

            string destination = string.Empty;
            string place = string.Empty;

            if(budget >= 100)
            {
                destination = "Bulgaria";
                if(season == "Summer")
                {
                    budget *= 0.3;
                    place = "Camp";
                }
                else if(season == "Winter")
                {
                    budget *= 0.7;
                    place = "Hotel";
                }
            }
            else if (budget <= 1000)
            {
                destination = "Balkans";
                if(season == "Summer")
                {
                    budget *= 0.4;
                    place = "Camp";
                }
                else if(season == "Winter")
                {
                    budget *= 0.9;
                    place = "Hotel";
                }
            }
            else
            {
                destination = "Europe";
                if (season == "Summer")
                {
                    budget *= 0.9;
                    place = "Hotel";
                }
                else if (season == "Winter")
                {
                    budget *= 0.9;
                    place = "Hotel";
                }
            }
            Console.WriteLine($"Somwhere in {destination}");
            Console.WriteLine($"{place} - {budget:F2}");
        }
    }
}
