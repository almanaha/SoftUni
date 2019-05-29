using System;
namespace _2.Spaceship
{
    class Program
    {
        static void Main()
        {
            double width = double.Parse(Console.ReadLine());
            double length = double.Parse(Console.ReadLine());
            double heigth = double.Parse(Console.ReadLine());
            double avgHeigthOfAstrounaut = double.Parse(Console.ReadLine());

            double sizeOfRocket = width * length * heigth;
            double sizeOfRooms = (avgHeigthOfAstrounaut + 0.40) * 2 * 2;
            double totalSpace = Math.Floor(sizeOfRocket / sizeOfRooms);

            if (totalSpace >= 3 && totalSpace <= 10)
            {
                Console.WriteLine($"The spacecraft holds {totalSpace} astronauts.");

            }
            else if (totalSpace < 3)
            {
                Console.WriteLine("The spacecraft is too small.");
            }
            else if (totalSpace > 10)
            {
                Console.WriteLine("The spacecraft is too big.");
            }
        }
    }
}
