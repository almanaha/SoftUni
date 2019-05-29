using System;
namespace _6.Foreign_Languages
{
    class Program
    {
        static void Main()
        {
            string nation = Console.ReadLine();

            switch (nation)
            {
                case "USA": 
                case "England": Console.WriteLine("English"); break;
                case "Spain":
                case "Argentina":
                case "Mexico": Console.WriteLine("Spanish"); break;
                default:
                    Console.WriteLine("unknown");
                    break;
            }
        }
    }
}
