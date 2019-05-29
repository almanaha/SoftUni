using System;
namespace Group_Stage
{
    class Program
    {
        static void Main()
        {
            string team = Console.ReadLine();
            int games = int.Parse(Console.ReadLine());

            int points = 0;
            int totalGoalScored = 0;
            int totalGoalReceived = 0;

            for (int gameNumber = 0; gameNumber < games; gameNumber++)
            {
                int goalsScored = int.Parse(Console.ReadLine());
                int goalsReceived = int.Parse(Console.ReadLine());

                if (goalsScored > goalsReceived)
                {
                    points += 3;
                }
                else if(goalsScored == goalsReceived)
                {
                    points += 1;
                }
                totalGoalScored += goalsScored;
                totalGoalReceived += goalsReceived;
            }

            int goalDiff = totalGoalScored - totalGoalReceived;

            if (totalGoalScored >= totalGoalReceived)
            {
                Console.WriteLine($"{team} has finished the group phase with {points} points.");
                Console.WriteLine($"Goal difference: {goalDiff}.");
            }
            else
            {
                Console.WriteLine($"{team} has been eliminated from the group phase.");
                Console.WriteLine($"Goal difference: {goalDiff}.");
            }
        }
    }
}
