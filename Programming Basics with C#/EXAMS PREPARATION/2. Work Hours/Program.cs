using System;
namespace _2.Work_Hours
{
    class Program
    {
        static void Main()
        {
            var hoursNeeded = int.Parse(Console.ReadLine());
            var workersCount = int.Parse(Console.ReadLine());
            var daysWorking = int.Parse(Console.ReadLine());

            var totalHours = (workersCount * 8) * daysWorking;

            if (totalHours > hoursNeeded)
            {
                var leftHours = totalHours - hoursNeeded;
                Console.WriteLine($"{leftHours} hours left");
            }
            else
            {
                var overtime = hoursNeeded - totalHours;
                var penalties = overtime * daysWorking;

                Console.WriteLine($"{overtime} overtime");
                Console.WriteLine($"Penalties: {penalties}");
            }
        }
    }
}
