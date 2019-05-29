using System;
namespace Game_Info
{
    class Program
    {
        static void Main()
        {
            string team = Console.ReadLine();
            int gamesPlyed = int.Parse(Console.ReadLine());

            int gamesWithPenalties = 0;
            int sumGames = 0;

            for (int currentGame = 1; currentGame <= gamesPlyed; currentGame++)
            {
                int gameMinutes = int.Parse(Console.ReadLine());
                sumGames += gameMinutes;

            }
        }
    }
}
