using System;
namespace _5.Trekking_Mania
{
    class Program
    {
        static void Main()
        {
            double group = double.Parse(Console.ReadLine());

            double totalPeople = 0;

            double totalForMusala = 0;
            double totalForMonblan = 0;
            double totalForKilimanjaro = 0;
            double totalForK2 = 0;
            double totalForEverest = 0;

            for (double i = 1; i <= group; i++)
            {
                double people = double.Parse(Console.ReadLine());
                totalPeople += people;

                if (people <= 5)
                {
                    totalForMusala += people;
                }
                else if (people >= 6 && people <= 12)
                {
                    totalForMonblan += people;
                }
                else if (people >= 13 && people <= 25)
                {
                    totalForKilimanjaro += people;
                }
                else if (people >= 26 && people <= 40)
                {
                    totalForK2 += people;
                }
                else if (people >= 41)
                {
                    totalForEverest += people;
                }
            }
            double percentageMusala = (totalForMusala / totalPeople) * 100;
            double percentageMonblan = (totalForMonblan / totalPeople) * 100;
            double percentageKilimanjaro  = (totalForKilimanjaro / totalPeople) * 100;
            double percentageK2 = (totalForK2 / totalPeople) * 100;
            double percentageEverest = (totalForEverest / totalPeople) * 100;

            Console.WriteLine($"{percentageMusala:F2}%");
            Console.WriteLine($"{percentageMonblan:F2}%");
            Console.WriteLine($"{percentageKilimanjaro:F2}%");
            Console.WriteLine($"{percentageK2:F2}%");
            Console.WriteLine($"{percentageEverest:F2}%");
        }
    }
}
