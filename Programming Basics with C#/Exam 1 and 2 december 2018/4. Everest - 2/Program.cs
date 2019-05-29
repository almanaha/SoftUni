using System;

class Everest
{
    static void Main(string[] args)
    {
        int days = 1;
        int sumMeters = 5364;

        while (sumMeters < 8848)
        {
            string command = Console.ReadLine();
            if (command == "Yes")
            {
                days++;
            }
            if (command == "END")
            {
                break;
            }
            if (days > 5)
            {
                break;
            }
            int meters = int.Parse(Console.ReadLine());
            sumMeters += meters;
        }
        if (sumMeters >= 8848)
        {
            Console.WriteLine($"Goal reached for {days} days!");
        }
        else
        {
            Console.WriteLine("Failed!");
            Console.WriteLine($"{sumMeters}");
        }
    }
}

