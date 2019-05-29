using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace graduation
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();

            int currentClass = 1;
            double sumGrades = 0.0;
            while(currentClass <= 12)
            {
                double grade = double.Parse(Console.ReadLine());
                if (grade >= 4)
                {
                    currentClass++;
                    sumGrades += grade;
                }
            }
            Console.WriteLine($"{name} graduated. Average grade: {sumGrades / 12:F2}");
        }
    }
}
