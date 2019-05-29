using System;
class Program
{
    static void Main(string[] args)
    {
        int freeDays = int.Parse(Console.ReadLine());

        int workDays = 365 - freeDays;
        int totalMinsPlaying = workDays * 63 + freeDays * 127; // in mins
        int diff = Math.Abs(totalMinsPlaying - 30000);
        int hours = diff / 60;
        int minutes = diff % 60;

        if (totalMinsPlaying > 30000)
        {
            Console.WriteLine("Tom will run away");
            Console.WriteLine($"{hours} hours and {minutes} minutes more for play");
        }
        else
        {
            Console.WriteLine("Tom sleeps well");
            Console.WriteLine($"{hours} hours and {minutes} minutes less for play");
        }
    }
}

