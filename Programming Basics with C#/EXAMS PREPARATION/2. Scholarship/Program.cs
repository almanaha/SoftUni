using System;
class Program
{
    static void Main()
    {
        double income = double.Parse(Console.ReadLine());
        double avgGrade = double.Parse(Console.ReadLine());
        double minSalary = double.Parse(Console.ReadLine());

        double socialScholarship = 0;
        double exellentScholarship = 0;

        if (income < minSalary && avgGrade > 4.5)
        {
            socialScholarship = minSalary * 0.35;
        }
        if (avgGrade >= 5.5)
        {
            exellentScholarship = avgGrade * 25;
        }
        if (socialScholarship == 0 && exellentScholarship == 0)
        {
            Console.WriteLine("You cannot get a scholarship!");
        }
        else
        {
            if (socialScholarship > exellentScholarship)
            {
                Console.WriteLine($"You get a Social scholarship {socialScholarship} BGN");
            }
            else
            {
                Console.WriteLine($"You get a scholarship for exellent results {exellentScholarship} BGN");
            }
        }
    }
}

