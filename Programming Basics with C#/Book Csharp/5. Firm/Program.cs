using System;
class Program
{
    static void Main()
    {
        int hours = int.Parse(Console.ReadLine()); // Needed
        int days = int.Parse(Console.ReadLine()); // for the project
        int extraWork = int.Parse(Console.ReadLine()); // working overtime

        double training = days * 0.1;
        double totalDays = days - training;
        double workingHours = totalDays * 8;
        double overtime = (extraWork * 2) * days;

        double totalTime = workingHours + overtime;
        if (totalTime > hours)
        {
            Console.WriteLine($"Yes!{Math.Floor(totalTime - hours)} hours left.");
        }
        else
        {
            Console.WriteLine($"Not enough time!{Math.Ceiling(hours - totalTime)} hours needed.");
        }
    }
}

