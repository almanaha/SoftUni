using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Summer_Outfit
{
    class Program
    {
        static void Main(string[] args)
        {
            int degrees = int.Parse(Console.ReadLine());
            string dayTime = Console.ReadLine();

            if (dayTime == "Morning")
            {
                if(degrees >= 10 && degrees <= 18)
                {
                    Console.WriteLine($"It's {degrees} degrees, get your Sweatshirt and Sneakers.");
                }
                else if(degrees > 18 && degrees <= 24)
                {
                    Console.WriteLine($"It's {degrees} degrees, get your Shirt and Moccasins.");
                }
                else if(degrees >= 25)
                {
                    Console.WriteLine($"It's {degrees} degrees, get your T-Shirt and Sandals.");
                }
            }
            if (dayTime == "Afternoon")
            {
                if(degrees >= 10 && degrees <= 18)
                {
                    Console.WriteLine($"It's {degrees} degrees, get your Shirt and Moccasins.");
                }
                else if(degrees > 18 && degrees <= 24)
                {
                    Console.WriteLine($"It's {degrees} degrees, get your T-Shirt and Sandals.");
                }
                else if(degrees >= 25)
                {
                    Console.WriteLine($"It's {degrees} degrees, get your Swim Suit and Barefoot.");
                }
            }
            if (dayTime == "Evening")
            {
               Console.WriteLine($"It's {degrees} degrees, get your Shirt and Moccasins.");
            }
        }
    }
}
