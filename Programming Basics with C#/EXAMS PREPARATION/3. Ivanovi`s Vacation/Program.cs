using System;
namespace _3.Ivanovi_s_Vacation
{
    class Program
    {
        static void Main()
        {
            int nights = int.Parse(Console.ReadLine());
            string destination = Console.ReadLine();
            string transport = Console.ReadLine();

            double priceAdult = 0;
            double priceChild = 0;
            double transportAdult = 0;
            double transportChild = 0;

            switch (destination)
            {
                case "Miami":
                    if (nights <= 10)
                    {
                        priceAdult = 24.99;
                        priceChild = 14.99;
                    }
                    else if (nights <= 15)
                    {
                        priceAdult = 22.99;
                        priceChild = 11.99;

                    }
                    else
                    {
                        priceAdult = 20;
                        priceChild = 10;
                    }
                    break;
                case "Canary Islands":
                    if (nights <= 10)
                    {
                        priceAdult = 32.50;
                        priceChild = 28.50;
                    }
                    else if (nights <= 15)
                    {
                        priceAdult = 30.50;
                        priceChild = 25.60;

                    }
                    else
                    {
                        priceAdult = 28;
                        priceChild = 22;
                    }
                    break;
                case "Philippines":
                    if (nights <= 10)
                    {
                        priceAdult = 42.99;
                        priceChild = 39.99;
                    }
                    else if (nights <= 15)
                    {
                        priceAdult = 41.00;
                        priceChild = 36;

                    }
                    else
                    {
                        priceAdult = 38.50;
                        priceChild = 32.40;
                    }break;
            }
            switch (transport)
            {
                case "train": transportAdult = 22.30;
                    transportChild = 12.50; break;
                case "bus": transportAdult = 45;
                    transportChild = 37; break;
                case "airplane": transportAdult = 90;
                    transportChild = 68.50; break;
            }

            double hotel = (nights * (2 * priceAdult + 3 * priceChild)) * 1.25;
            double transportSum = 2 * transportAdult + 3 * transportChild;
            double totalPrice = hotel + transportSum;

            Console.WriteLine($"{totalPrice:F3}");
        }
    }
}
