using System;
namespace WeddingInvestments
{
    class Program
    {
        static void Main()
        {
            string timeOfContract = Console.ReadLine();
            string TypeOfContract = Console.ReadLine();
            string IfDesert = Console.ReadLine();
            int Months = int.Parse(Console.ReadLine());

            double price = 0;
            double priceDesert = 0;
            double finalPriceDesert = 0;
            double total = 0;

            switch (TypeOfContract)
            {
                case "Small":
                    switch (timeOfContract)
                    {
                        case "one": price = 9.98; break;
                        case "two": price = 8.58; break;
                        default: break;
                    }break;
                case "Middle":
                    switch (timeOfContract)
                    {
                        case "one": price = 18.99; break;
                        case "two": price = 17.09; break;
                        default: break;
                    } break;
                case "Large":
                    switch (timeOfContract)
                    {
                        case "one": price = 25.98; break;
                        case "two": price = 23.59; break;
                        default: break;
                    } break;
                case "ExtraLarge":
                    switch (timeOfContract)
                    {
                        case "one": price = 35.99; break;
                        case "two": price = 31.79; break;
                        default: break;
                    } break;
                default: break;
            } 

            if (IfDesert == "yes")
            {
                if (price <= 10)
                {
                    priceDesert = 5.50;
                }
                else if (price > 10 && price <= 30)
                {
                    priceDesert = 4.35;
                }
                else if (price > 30)
                {
                    priceDesert = 3.85;
                }
            }

            if (timeOfContract == "two")
            {
                double totalPrice = price + priceDesert;
                double discount = totalPrice * 0.0375;
                total = (totalPrice - discount) * Months;
            }
            else
            {
                total = (price + priceDesert) * Months;
            }

            Console.WriteLine($"{total:f2} lv.");
        }
    }
}
