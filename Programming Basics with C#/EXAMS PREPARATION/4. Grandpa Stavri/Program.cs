using System;
namespace _4.Grandpa_Stavri
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            var totalLiters = 0.0;
            var avgDegrees = 0.0;

            for (int i = 1; i <= n; i++)
            {
                double liters = double.Parse(Console.ReadLine());
                double degrees = double.Parse(Console.ReadLine());

                totalLiters += liters;
                avgDegrees += liters * degrees;
            }

            avgDegrees = avgDegrees / totalLiters;

            Console.WriteLine($"Liter: {totalLiters:F2}");
            Console.WriteLine($"Degrees: {avgDegrees:F2}");

            if (avgDegrees < 38)
            {
                Console.WriteLine("Not good, you should baking!");
            }
            else if(avgDegrees <= 42)
            {
                Console.WriteLine("Super!");
            }
            else
            {
                Console.WriteLine("Dilution with destilled water!");
            }
        }
    }
}
