using System;
namespace _2.Calorie_Calculator
{
    class Program
    {
        static void Main()
        {
            char gender = char.Parse(Console.ReadLine());
            double weight = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());
            int age = int.Parse(Console.ReadLine());
            string physicalActivity = Console.ReadLine();

            double blm = 0.0;

            if (gender == 'm')
            {
                blm = 66 + (13.7 * weight) + (5 * height * 100) - (6.8 * age);
            }
            else if (gender == 'f')
            {
                blm = 655 + (9.6 * weight) + (1.8 * height * 100) - (4.7 * age);
            }

            if (physicalActivity == "sedentary")
            {
                blm *= 1.2;
            }
            else if (physicalActivity == "lightly active")
            {
                blm *= 1.375;
            }
            else if (physicalActivity == "moderately active")
            {
                blm *= 1.55;
            }
            else if (physicalActivity == "very active")
            {
                blm *= 1.725;
            }

            Console.WriteLine($"To maintain your current weight you will need {Math.Ceiling(blm)} calories per day.");
        }
    }
}
