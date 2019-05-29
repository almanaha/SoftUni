using System;
namespace _4.Back_In_30_Minutes
{
    class Program
    {
        static void Main()
        {
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());
            
            double extraMins = minutes + 30;
            double total;
            if (extraMins > 59)
            {
                if (hours == 23)
                {
                    hours = -1;
                    
                }
                hours += 1;
                extraMins -= 60;
                Console.WriteLine($"{hours}:{extraMins}");
            }
            else if (hours == 0)
            {
                Console.WriteLine($"0:{extraMins}");
            }
            else if (extraMins < 10)
            {
                Console.WriteLine($"{hours}:0{extraMins}");
            }
            else if(hours == 23)
            {
                hours -= 22;
                Console.WriteLine($"{hours}:{extraMins}");
            }
            else
            {
                Console.WriteLine($"{hours}:{extraMins}");
            }
        }
    }
}
