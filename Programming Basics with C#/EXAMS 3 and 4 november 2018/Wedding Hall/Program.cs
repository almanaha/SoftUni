using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Wedding_Hall
{
    class Program
    {
        static void Main(string[] args)
        {
            double lengthHall = double.Parse(Console.ReadLine());
            double widthhHall = double.Parse(Console.ReadLine());
            double bar = double.Parse(Console.ReadLine());

            double sizeOfHallInMeters = lengthHall * widthhHall;
            double sizeOfBar = bar * bar;
            double sizeOfDancingFloor = sizeOfHallInMeters * 0.19;
            double freeSpace = sizeOfHallInMeters - sizeOfBar - sizeOfDancingFloor;
            double guests = Math.Ceiling(freeSpace / 3.2);

            Console.WriteLine(guests);
        }
    }
}
