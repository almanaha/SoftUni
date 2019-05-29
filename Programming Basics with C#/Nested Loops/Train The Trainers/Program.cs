using System;
namespace Train_The_Trainers
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            string presentation = Console.ReadLine();
            int count = 0;
            double sumGrade = 0;

            while (presentation != "Finish")
            {
                count++;
                double sum = 0;
                for (int i = 1; i <= n; i++)
                {
                    double grade = double.Parse(Console.ReadLine());
                    sum += grade;
                }
                double avgGrade = sum / n;
                sumGrade += avgGrade;
                Console.WriteLine($"{presentation} - {avgGrade:F2}.");
                presentation = Console.ReadLine();
            }
            double finalGrade = sumGrade / count;
            Console.WriteLine($"Student's final assessment is {finalGrade:F2}.");
        }
    }
}
