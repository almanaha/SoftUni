using System;
namespace Cinema
{
    class Program
    {
        static void Main()
        {
            string movieType = Console.ReadLine();
            double countRows = double.Parse(Console.ReadLine());
            double countColumns = double.Parse(Console.ReadLine());

            double profit = 0;
            double people = countRows * countColumns;

            if(movieType == "Premiere")
            {
                double moneyP = people * 12.00;
                Console.WriteLine($"{moneyP:F2} leva"); 
            }
            else if(movieType == "Normal")
            {
                double moneyN = people * 7.50;
                Console.WriteLine($"{moneyN:F2} leva");
            }
            else if (movieType == "Discount")
            {
                double moneyD = people * 5.00;
                Console.WriteLine($"{moneyD:F2} leva");
            }
        }
    }
}
