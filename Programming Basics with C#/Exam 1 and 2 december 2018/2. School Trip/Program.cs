using System;
namespace _2.School_Trip
{
    class Program
    {
        static void Main()
        {
            int countDays = int.Parse(Console.ReadLine());
            double food = double.Parse(Console.ReadLine()); // in kg
            double foodforDog1 = double.Parse(Console.ReadLine()); // in kg
            double foodforDog2 = double.Parse(Console.ReadLine()); // in kg
            double foodforDog3 = double.Parse(Console.ReadLine()); // in kg

            double dog1 = countDays * foodforDog1;
            double dog2 = countDays * foodforDog2;
            double dog3 = countDays * foodforDog3;

            double totalFood = dog1 + dog2 + dog3;

            if (totalFood <= food)
            {
                Console.WriteLine($"{Math.Ceiling(food-totalFood)} kilos of food left.");
            }
            else
            {
                Console.WriteLine($"{Math.Ceiling(totalFood-food)} more kilos of food are needed.");
            }

        }
    }
}
