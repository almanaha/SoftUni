using System;
namespace _3.Sushi_Time
{
    class Program
    {
        static void Main()
        {
            string sushiType = Console.ReadLine();
            string sushiRestaurant = Console.ReadLine();
            int meals = int.Parse(Console.ReadLine());
            string order = Console.ReadLine();

            double sushiPrice = 0;
            switch (sushiType)
            {
                case "sashimi":
                    switch (sushiRestaurant)
                    {
                        case "Sushi Zone": sushiPrice = 4.99; break;
                        case "Sushi Time": sushiPrice = 5.49; break;
                        case "Sushi Bar": sushiPrice = 5.25; break;
                        case "Asian Pub": sushiPrice = 4.50; break;
                        default: Console.WriteLine($"{sushiRestaurant} is invalid restaurant!"); break;
                    }
                    break;
                case "maki":
                    switch (sushiRestaurant)
                    {
                        case "Sushi Zone": sushiPrice = 5.29; break;
                        case "Sushi Time": sushiPrice = 4.69; break;
                        case "Sushi Bar": sushiPrice = 5.55; break;
                        case "Asian Pub": sushiPrice = 4.80; break;
                        default: Console.WriteLine($"{sushiRestaurant} is invalid restaurant!"); break;
                    }
                    break;
                case "uramaki":
                    switch (sushiRestaurant)
                    {
                        case "Sushi Zone": sushiPrice = 5.99; break;
                        case "Sushi Time": sushiPrice = 4.49; break;
                        case "Sushi Bar": sushiPrice = 6.25; break;
                        case "Asian Pub": sushiPrice = 5.50; break;
                        default: Console.WriteLine($"{sushiRestaurant} is invalid restaurant!"); break;
                    }
                    break;
                case "temaki":
                    switch (sushiRestaurant)
                    {
                        case "Sushi Zone": sushiPrice = 4.29; break;
                        case "Sushi Time": sushiPrice = 5.19; break;
                        case "Sushi Bar": sushiPrice = 4.75; break;
                        case "Asian Pub": sushiPrice = 5.50; break;
                        default: Console.WriteLine($"{sushiRestaurant} is invalid restaurant!"); break;
                    }
                    break;

            }
            if (sushiPrice != 0)
            {
                double totalMeal = meals * sushiPrice;
                if (order == "Y")
                {
                    totalMeal += totalMeal * 0.2;
                }

                Console.WriteLine($"Total price: {Math.Ceiling(totalMeal)} lv.");
            }
        }
    }
}
