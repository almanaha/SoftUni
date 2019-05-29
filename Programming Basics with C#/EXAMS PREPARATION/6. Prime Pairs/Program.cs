using System;
class Program
{
    static void Main()
    {
        int pair1 = int.Parse(Console.ReadLine());
        int pair2 = int.Parse(Console.ReadLine());
        int diff1 = int.Parse(Console.ReadLine());
        int diff2 = int.Parse(Console.ReadLine());

        int firstPair = pair1 + diff1;
        int secondPair = pair2 + diff2;

        for (int first = pair1; first <= firstPair; first++)
        {
            for (int second = pair2; second <= secondPair; second++)
            {
                bool isFirstPrime = true;
                bool isSecondPrime = true;
                //В Math.Sqrt(numer) подаваш някакво число и този метод ще ти върне неговия корен квадратен. Например: 225 е стойноста на числото и след използването на Math.Sqrt() ще получиш 15. Именно в тази задача е добре да се исполза, защото цикъла няма да се върти до 225 а до 15.
                for (int i = 2; i <= Math.Sqrt(first); i++)
                {
                    if (first % i == 0)
                    {
                        isFirstPrime = false;
                        break;
                    }
                }
                for (int j = 2; j <= Math.Sqrt(second); j++)
                {
                    if (second % j == 0)
                    {
                        isSecondPrime = false;
                        break;
                    }
                }
                if (isFirstPrime && isSecondPrime)
                {
                    Console.WriteLine($"{first}{second}");
                }
            }
        }
    }
}

