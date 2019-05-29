using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace metric_convertor
{
    class Program
    {
        static void Main(string[] args)
        {
            double numForCovert = double.Parse(Console.ReadLine());
            string incomeUnit = Console.ReadLine();
            string outcomeUnit = Console.ReadLine();

            double firstUnit = 0;
            double m = 1;
            double mm = 1000;
            double cm = 100;
            double mi = 0.000621371192;
            double @in = 39.3700787;
            double km = 0.001;
            double ft = 3.2808399;
            double yd = 1.0936133;

            if (incomeUnit == "m")
            {
                firstUnit = numForCovert / m;
            }
            else if (incomeUnit == "mm")
            {
                firstUnit = numForCovert / mm;
            }
            else if (incomeUnit == "cm")
            {
                firstUnit = numForCovert / cm;
            }
            else if (incomeUnit == "mi")
            {
                firstUnit = numForCovert / mi;
            }
            else if (incomeUnit == "in")
            {
                firstUnit = numForCovert / @in;
            }
            else if (incomeUnit == "km")
            {
                firstUnit = numForCovert / km;
            }
            else if (incomeUnit == "ft")
            {
                firstUnit = numForCovert / ft;
            }
            else if (incomeUnit == "yd")
            {
                firstUnit = numForCovert / yd;
            }

            double result = 0;

            if(outcomeUnit == "m")
            {
                result = firstUnit * m;
            }
            else if(outcomeUnit == "mm")
            {
                result = firstUnit * mm;
            }
            else if(outcomeUnit == "cm")
            {
                result = firstUnit * cm;
            }
            else if(outcomeUnit == "mi")
            {
                result = firstUnit * mi;
            }
            else if(outcomeUnit == "in")
            {
                result = firstUnit * @in;
            }
            else if(outcomeUnit == "km")
            {
                result = firstUnit * km;
            }
            else if(outcomeUnit == "ft")
            {
                result = firstUnit * ft;
            }
            else if(outcomeUnit == "yd")
            {
                result = firstUnit * yd;
            }

            Console.WriteLine($"{result:F8}");
        }
    }
}
