using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Scholarship
{
    class Program
    {
        static void Main(string[] args)
        {
            double income = double.Parse(Console.ReadLine());
            double averageGrade = double.Parse(Console.ReadLine());
            double minWage = double.Parse(Console.ReadLine());

            double socialWage = Math.Floor(0.35 * minWage);
            double scolarship = Math.Floor(averageGrade * 25);

            if(income > minWage && averageGrade < 4.50)
            {
                Console.WriteLine("You cannot get a scholarship!");
            }
            else if( income <= minWage && averageGrade >= 4.50 && averageGrade < 5.50)
            {
                Console.WriteLine($"You get a Social scholarship {socialWage} BGN");
            }
            else if( income > minWage && (averageGrade < 5.50 || averageGrade <= 4.50))
            {
                Console.WriteLine("You cannot get a scholarship!");
            }
            else
            {
                if(averageGrade <= minWage)
                {
                    if (scolarship >= socialWage)
                    {
                        Console.WriteLine($"You get a scholarship for excellent results {scolarship} BGN");
                    }
                    else
                    {
                        Console.WriteLine($"You get a Social scholarship {socialWage} BGN");
                    }
                }
                else
                {
                    Console.WriteLine($"You get a scholarship for excellent results {scolarship} BGN");
                }
            }
            
        }
    }
}
