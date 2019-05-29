using System;
namespace _4.Grades
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            double sum = 0;

            int failCount = 0;
            int goodCount = 0;
            int verygoodCount = 0;
            int excellent = 0;

            for (int i = 1; i <= n; i++)
            {
                double currentGrade = double.Parse(Console.ReadLine());
                sum += currentGrade;

                if (currentGrade < 3)
                {
                    failCount++;
                }
                else if (currentGrade < 4)
                {
                    goodCount++;
                }
                else if (currentGrade < 5)
                {
                    verygoodCount++;
                }
                else if (currentGrade <= 6)
                {
                    excellent++;
                }
            }
            double percentage1 = (excellent / (double)n) * 100;
            double percentage2 = (verygoodCount / (double)n) * 100;
            double percentage3 = (goodCount / (double)n) * 100;
            double percentage4 = (failCount / (double)n) * 100;
            double avg = sum / n;

            Console.WriteLine($"Top students: {percentage1:F2}%");
            Console.WriteLine($"Between 4.00 and 4.99: {percentage2:F2}%");
            Console.WriteLine($"Between 3.00 and 3.99: {percentage3:F2}%");
            Console.WriteLine($"Fail: {percentage4:F2}%");
            Console.WriteLine($"Average: {avg:F2}");

        }
    }
}
