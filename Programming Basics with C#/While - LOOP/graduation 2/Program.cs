using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace graduation_2
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();

            int currentClass = 1;
            double sumGrades = 0.0;
            int badGrades = 0;
            while (currentClass <= 12)
            {
                double grade = double.Parse(Console.ReadLine());
                if (grade >= 4)
                {
                    sumGrades += grade;
                    if(currentClass == 12)
                    {
                        Console.WriteLine($"{name} graduated. Average grade: {sumGrades / 12:F2}");
                        break;
                    }
                    currentClass++;
                }
                else
                {
                    badGrades++;
                    if(badGrades == 2)
                    {
                        Console.WriteLine($"{name} has been excluded at {currentClass} grade");
                        break;
                    }
                }
            }
        }
    }
}
