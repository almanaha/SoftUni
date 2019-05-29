using System;
namespace _7.Vending_Machine
{
    class Program
    {
        static void Main()
        {
            decimal totalMoney = 0;

            while (true)
            {
                string money = Console.ReadLine();

                if (money == "Start")
                {
                    break;
                }

                decimal coins = decimal.Parse(money);

                if (coins == 0.1m || coins == 0.2m || coins == 0.5m || coins==1m || coins==2m)
                {
                    totalMoney += coins;
                }
                else
                {
                    Console.WriteLine($"Cannot accept {coins}");
                }
            }

            while (true)
            {
                string product = Console.ReadLine().ToLower();

                if (product == "end")
                {
                    break;
                }

                if (product == "nuts")
                {
                    if (totalMoney < 2)
                    {
                        Console.WriteLine("Sorry, not enough money");
                        continue;
                    }
                    Console.WriteLine($"Purchased {product}");
                    totalMoney -= 2;
                }
                else if (product == "water")
                {
                    if (totalMoney < 0.7m)
                    {
                        Console.WriteLine("Sorry, not enough money");
                        continue;
                    }
                    Console.WriteLine($"Purchased {product}");
                    totalMoney -= 0.7m;
                }
                else if (product == "crisps")
                {
                    if (totalMoney < 1.50m)
                    {
                        Console.WriteLine("Sorry, not enough money");
                        continue;
                    }
                    Console.WriteLine($"Purchased {product}");
                    totalMoney -= 1.50m;
                }
                else if (product == "soda")
                {
                    if (totalMoney < 0.8m)
                    {
                        Console.WriteLine("Sorry, not enough money");
                        continue;
                    }
                    Console.WriteLine($"Purchased {product}");
                    totalMoney -= 0.8m;
                }
                else if (product == "coke")
                {
                    if (totalMoney < 1m)
                    {
                        Console.WriteLine("Sorry, not enough money");
                        continue;
                    }
                    Console.WriteLine($"Purchased {product}");
                    totalMoney -= 1m;
                }
                else
                {
                    Console.WriteLine("Invalid product");
                }
            }

            Console.WriteLine($"Change: {totalMoney:F2}");
        }
    }
}
