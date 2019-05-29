using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace World_Swimming_Record
{
    class Program
    {
        static void Main(string[] args)
        {
            double record = double.Parse(Console.ReadLine());
            double distance = double.Parse(Console.ReadLine());
            double timeInSeconds = double.Parse(Console.ReadLine());

            double totalTime = (distance * timeInSeconds);
            double slowTime = Math.Floor(distance / 15) * 12.5;

            double ivanchoRecod = totalTime + slowTime;

            if (ivanchoRecod < record)
            {
                Console.WriteLine($"Yes, he succeeded! The new world record is {ivanchoRecod:f2} seconds.");
            }
            else
            {
                double success = ivanchoRecod - record;
                Console.WriteLine($"No, he failed! He was {success:f2} seconds slower.");
            }
        }
    }
}
