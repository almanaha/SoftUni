using System;
namespace _4.Game_of_Intervals
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            double points = 0;
            double firstInterval = 0;
            double secondInterval = 0;
            double thirdInterval = 0;
            double fourthInterval = 0;
            double fifthInterval = 0;
            double sixthInterval = 0;

            for (int i = 1; i <= n; i++)
            {
                int number = int.Parse(Console.ReadLine());
                
                if (number >= 0 && number <= 9)
                {
                    points += number * 0.2;
                    firstInterval++;
                }
                else if (number >= 10 && number <= 19)
                {
                    points += number * 0.3;
                    secondInterval++;
                }
                else if (number >= 20 && number <= 29)
                {
                    points += number * 0.4;
                    thirdInterval++;
                }
                else if (number >= 30 && number <= 39)
                {
                    points += 50;
                    fourthInterval++;
                }
                else if (number >= 40 && number <= 50)
                {
                    points += 100;
                    fifthInterval++;
                }
                else
                {
                    points /= 2;
                    sixthInterval++;
                }
            }
            double allMoves = firstInterval + secondInterval + thirdInterval + fourthInterval + fifthInterval + sixthInterval;

            double percengate1 = (firstInterval / allMoves) * 100;
            double percengate2 = (secondInterval / allMoves) * 100;
            double percengate3 = (thirdInterval / allMoves) * 100;
            double percengate4 = (fourthInterval / allMoves) * 100;
            double percengate5 = (fifthInterval / allMoves) * 100;
            double percengate6 = (sixthInterval / allMoves) * 100;

            Console.WriteLine($"{points:F2}");
            Console.WriteLine($"From 0 to 9: {percengate1:F2}%");
            Console.WriteLine($"From 10 to 19: {percengate2:F2}%");
            Console.WriteLine($"From 20 to 29: {percengate3:F2}%");
            Console.WriteLine($"From 30 to 39: {percengate4:F2}%");
            Console.WriteLine($"From 40 to 50: {percengate5:F2}%");
            Console.WriteLine($"Invalid numbers: {percengate6:F2}%");



        }
    }
}
