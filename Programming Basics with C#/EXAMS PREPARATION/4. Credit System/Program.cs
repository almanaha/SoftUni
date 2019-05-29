using System;
namespace _4.Credit_System
{
    class Program
    {
        static void Main()
        {
            var n = int.Parse(Console.ReadLine());

            double sum = 0;
            double credits = 0;

            for (int i = 0; i < n; i++)
            {

                var input = Console.ReadLine();

                var c = input.Length();
                int grade = int.Parse(c.ToString());
                sum += grade;
                var credit = double.Parse(input.TrimEnd(c));

                switch (grade)
                {
                    case 2: credit = 0; break;
                    case 3: credit = credit / 2; break;
                    case 4: credit = credit * 0.7; break;
                    case 5: credit = credit * 0.85; break;

                }
                credits += credit;
            }
            Console.WriteLine("{0:f2}", credits);
            Console.WriteLine("{0:f2}", sum / n);
        }
    }
}
