using System;
namespace _5.Project_Prize
{
    class Program
    {
        static void Main()
        {
            int project = int.Parse(Console.ReadLine());
            double award = double.Parse(Console.ReadLine());

            int totalPoints = 0;

            for (int i = 1; i <= project; i++)
            {
                int point = int.Parse(Console.ReadLine());
                if (i % 2 == 0)
                {
                    point *= 2;
                    totalPoints += point;
                }
                else
                {
                    totalPoints += point;
                }
            }
            double awardSum = award * totalPoints;

            Console.WriteLine($"The project prize was {awardSum:F2} lv.");
        }
    }
}
