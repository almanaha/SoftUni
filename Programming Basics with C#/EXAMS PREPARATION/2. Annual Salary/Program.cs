using System;
namespace _2.Annual_Salary
{
    class Program
    {
        static void Main()
        {

            int experience = int.Parse(Console.ReadLine());
            string specialty = Console.ReadLine();
            double salary = 0;
            if (specialty == "C# Developer")
                salary = 5400;
            else if (specialty == "Java Developer")
                salary = 5700;
            else if (specialty == "Front-End Web Developer")
                salary = 4100;
            else if (specialty == "UX / UI Designer")
                salary = 3100;
            else if (specialty == "Game Designer")
                salary = 3600;

            if (experience <= 5)
                salary -= salary * 0.658;

            double yearIncome = 12 * salary;
            Console.WriteLine($"Total earned money: {yearIncome:f2} BGN");
        }
    }
}
