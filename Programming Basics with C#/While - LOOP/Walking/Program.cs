using System;
namespace Walking
{
    class Program
    {
        static void Main()
        {
            string tired = string.Empty;
            int dailyGoal = 10000;
            int goal = 0;

            while (true)
            {
                int countOfSteps = int.Parse(Console.ReadLine());
                goal = goal + countOfSteps;
                if(goal == dailyGoal)
                {
                    Console.WriteLine("Goal reached! Good job!");
                    break;
                }
                if (tired == "Going home")
                {
                    int lastSteps = int.Parse(Console.ReadLine());
                    Console.WriteLine($"{dailyGoal - goal} more steps to reach goal.");
                    break;
                }

            }
        }
    }
}
