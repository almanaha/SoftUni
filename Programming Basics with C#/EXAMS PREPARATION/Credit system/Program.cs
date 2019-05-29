using System;
namespace Credit_system
{
    class Program
    {
        static void Main()
        {
            int coursesCount = int.Parse(Console.ReadLine());
            double totalCredits = 0;
            double totalGrades = 0;

            for (int i = 0; i < coursesCount; i++)
            {
                int number = int.Parse(Console.ReadLine());
                int grade = number % 10;
                int credits = number / 10;
                totalGrades += grade;

                if (grade == 3)
                {
                    totalCredits += credits * 0.5;
                }
                else if(grade == 4)
                {
                    totalCredits += credits * 0.7;
                }
                else if(grade == 5)
                {
                    totalCredits += credits * 0.85;
                }
                else if(grade == 6)
                {
                    totalCredits += credits;
                }
            }
            Console.WriteLine($"{totalCredits:F2}");

            double finalGrade = totalGrades / coursesCount;

            Console.WriteLine($"{finalGrade:F2}");
        }
    }
}
