using System;
namespace Volleyball
{
    class Program
    {
        static void Main()
        {
            string year = Console.ReadLine();
            double holidays = double.Parse(Console.ReadLine());
            double weekends = double.Parse(Console.ReadLine());

            double games = (48 - weekends) * 0.75 + weekends + holidays * 2 / 3;

            if(year == "leap")
            {
                games *= 1.15;
            }
            Console.WriteLine((int)games);
        }
    }
}
