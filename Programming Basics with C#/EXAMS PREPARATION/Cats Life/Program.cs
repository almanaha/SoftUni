using System;
namespace Cats_Life
{
    class Program
    {
        static void Main()
        {
            string breed = Console.ReadLine();
            string gender = Console.ReadLine();
            int canMonths = 0;

            switch (breed)
            {
                case "British Shorthair":
                    if (gender == "f")
                    {
                        canMonths = 14 * 2;
                    }
                    else
                    {
                        canMonths = 13 * 2;
                    }
                    break;
                case "Siamese":
                    if (gender == "f")
                    {
                        canMonths = 16 * 2;
                    }
                    else
                    {
                        canMonths = 15 * 2;
                    }
                    break;
                case "Persian":
                    if (gender == "f")
                    {
                        canMonths = 15 * 2;
                    }
                    else
                    {
                        canMonths = 14 * 2;
                    }
                    break;
                case "Ragdoll":
                    if (gender == "f")
                    {
                        canMonths = 17 * 2;
                    }
                    else
                    {
                        canMonths = 16 * 2;
                    }
                    break;
                case "American Shorthair":
                    if (gender == "f")
                    {
                        canMonths = 13 * 2;
                    }
                    else
                    {
                        canMonths = 12 * 2;
                    }
                    break;
                case "Siberian":
                    if (gender == "f")
                    {
                        canMonths = 12 * 2;
                    }
                    else
                    {
                        canMonths = 11 * 2;
                    }
                    break;
                default:
                    Console.WriteLine($"{breed} is invalid cat!");
                    break;
            }
            if (canMonths != 0)
            {
                Console.WriteLine($"{canMonths} cat months");
            }
        }
    }
}
