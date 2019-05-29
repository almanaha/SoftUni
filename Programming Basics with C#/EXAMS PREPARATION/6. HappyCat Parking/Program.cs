using System;
class Program
{
    static void Main()
    {
        int countDays = int.Parse(Console.ReadLine());
        int countHours = int.Parse(Console.ReadLine());

        double sum = 0;
        double total = 0;

        for (int day = 1; day <= countDays; day++)
        {
            for (int hour = 1; hour <= countHours; hour++)
            {
                if (day % 2 == 0 && hour % 2 == 1)
                {
                    sum += 2.50;
                }
                if (day % 2 == 1 && hour % 2 == 0)
                {
                    sum += 1.25;
                }
                if((day % 2 == 0 && hour % 2 == 0) || (day % 2 == 1 && hour % 2 == 1))
                {
                    sum += 1;
                }
            }
            total += sum;
            Console.WriteLine($"Day: {day} - {sum:F2} leva");
            sum = 0;
        }
        Console.WriteLine($"Total: {total:F2} leva");
    }
}

