using System;
namespace Histogram
{
    class Program
    {
        static void Main()
        {
            double n = double.Parse(Console.ReadLine());
            double firstCounter = 0;
            double secondCounter = 0;
            double thirdCounter = 0;
            double fourthCounter = 0;
            double fifthCounter = 0;


            for (int i = 0; i < n; i++)
            {
                double num = double.Parse(Console.ReadLine());

                if (num < 200)
                {
                    firstCounter++;
                }
                else if (num < 400)
                {
                    secondCounter++;
                }
                else if (num < 600)
                {
                    thirdCounter++;
                }
                else if (num < 800)
                {
                    fourthCounter++;
                }
                else if (num >= 800)
                {
                    fifthCounter++;
                }
            }

            double percentage1 = (firstCounter / n) * 100;
            double percentage2 = (secondCounter / n) * 100;
            double percentage3 = (thirdCounter / n) * 100;
            double percentage4 = (fourthCounter / n) * 100;
            double percentage5 = (fifthCounter / n) * 100;

            Console.WriteLine($"{percentage1:F2}%");
            Console.WriteLine($"{percentage2:F2}%");
            Console.WriteLine($"{percentage3:F2}%");
            Console.WriteLine($"{percentage4:F2}%");
            Console.WriteLine($"{percentage5:F2}%");
        }
    }
}
