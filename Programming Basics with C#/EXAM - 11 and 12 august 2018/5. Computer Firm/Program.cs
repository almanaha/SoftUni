using System;
namespace _5.Computer_Firm
{
    class Program
    {
        static void Main()
        {
            int num = int.Parse(Console.ReadLine());
            int sales = 0;
            int lastNum = 0;
            double rating = 0;
            double totalSales = 0;
            

            for (int i = 1; i <= num; i++)
            {
                int number = int.Parse(Console.ReadLine());

                sales = number / 10;
                lastNum = number % 10;
                rating += lastNum;

                if (lastNum == 3)
                {
                    totalSales += sales * 0.5;
                }
                else if (lastNum == 4)
                {
                    totalSales += sales * 0.7;
                }
                else if (lastNum == 5)
                {
                    totalSales += sales * 0.85;
                }
                else if (lastNum == 6)
                {
                    totalSales += sales;
                }

            }
            double avgRatingPerComputer = rating / num;

            Console.WriteLine($"{totalSales:F2}");
            Console.WriteLine($"{avgRatingPerComputer:F2}");
        }
    }
}
