using System;
namespace _5.Date_after_5_days
{
    class Program
    {
        static void Main()
        {
            var days = int.Parse(Console.ReadLine());
            var month = int.Parse(Console.ReadLine());


            var daysInMonth = 31;

            if (month == 4 || month == 6 || month == 9 || month == 11)
            {
                daysInMonth = 30;
            }
            else if (month == 2)
            {
                daysInMonth = 28;
            }

            days += 5;

            if (days > daysInMonth)
            {
                days -= daysInMonth;
                month++;
                if (month == 13)
                {
                    month = 1;
                    
                }
            }

            if (month<10)
            {
                Console.WriteLine($"{days}.0{month}");
            }
            else
            {
                Console.WriteLine($"{days}.{month}");
            }
        }
    }
}
