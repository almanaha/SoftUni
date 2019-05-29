using System;

class Training
{
    static void Main()
    {
        int days = int.Parse(Console.ReadLine());
        double km = double.Parse(Console.ReadLine());

        double totalKm = km;

        for (int i = 1; i <= days; i++)
        {
            double percentage = double.Parse(Console.ReadLine());
            km += (percentage / 100) * km;
            totalKm += km;
        }

        if (totalKm >= 1000)
        {
            double overTarget = Math.Ceiling(totalKm - 1000);
            Console.WriteLine($"You`ve done a great job running {overTarget} more kilometers!");
        }
        else
        {
            double lowTaret = Math.Ceiling(1000 - totalKm);
            Console.WriteLine($"Sorry Mrs. Ivanova, you need to run {lowTaret} more kilometers");
        }
    }
}

