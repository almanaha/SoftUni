using System;
class Program
{
    static void Main()
    {
        int capacityPool = int.Parse(Console.ReadLine()); // in liters
        int pipe1 = int.Parse(Console.ReadLine()); // water for 1 hour
        int pipe2 = int.Parse(Console.ReadLine()); // water for 1 hour
        double hoursWorking = double.Parse(Console.ReadLine());

        double water = (pipe1 + pipe2) * hoursWorking;
        int capacityPercentage = (int)((water / capacityPool) * 100);
        int pipe1Percentage = (int)((pipe1 * hoursWorking)/water * 100);
        int pipe2Percentage = (int)((pipe2 * hoursWorking)/water * 100);

        if (water <= capacityPool)
        {
            Console.WriteLine($"The pool is {capacityPercentage}% full. Pipe 1: {pipe1Percentage}%. Pipe 2: {pipe2Percentage}%.");
        }
        else
        {
            Console.WriteLine($"For {hoursWorking} hours the pool overflows with {water - capacityPool} liters.");
        }


    }
}

