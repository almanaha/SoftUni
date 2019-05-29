using System;
namespace _3.Energy_Booster
{
    class Program
    {
        static void Main()
        {
            string fruit = Console.ReadLine();
            string size = Console.ReadLine();
            int countSets = int.Parse(Console.ReadLine());

            double watermelon = 0;
            double mango = 0;
            double pineapple = 0;
            double raspberry = 0;

            double totalSum = 0;

            if (fruit == "Watermelon")
            {
                if (size=="small")
                {
                    watermelon = 2 * 56;
                    totalSum = watermelon * countSets;
                }
                else
                {
                    watermelon = 5 * 28.70;
                    totalSum = watermelon * countSets;
                }
            }
            else if (fruit == "Mango")
            {
                if (size == "small")
                {
                    mango = 2 * 36.66;
                    totalSum = mango * countSets;
                }
                else
                {
                    mango = 5 * 19.60;
                    totalSum = mango * countSets;
                }
            }
            else if (fruit == "Pineapple")
            {
                if (size == "small")
                {
                    pineapple = 2 * 42.10;
                    totalSum = pineapple * countSets;

                }
                else
                {
                    pineapple = 5 * 24.80;
                    totalSum = pineapple * countSets;
                }
            }
            else if (fruit == "Raspberry")
            {
                if (size == "small")
                {
                    raspberry = 2 * 20;
                    totalSum = raspberry * countSets;
                }
                else
                {
                    raspberry = 5 * 15.20;
                    totalSum = raspberry * countSets;
                }
            }

            if (totalSum >= 400 && totalSum <= 1000)
            {
                double discount = totalSum * 0.85;
                Console.WriteLine($"{discount:F2} lv.");
            }
            else if (totalSum > 1000)
            {
                double discount = totalSum * 0.5;
                Console.WriteLine($"{discount:F2} lv.");
            }
            else
            {
                Console.WriteLine($"{totalSum:F2} lv.");
            }
        }
    }
}
