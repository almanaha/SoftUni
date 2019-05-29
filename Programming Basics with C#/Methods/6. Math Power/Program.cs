using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _6.Math_Power
{
    class Program
    {
        static void Main(string[] args)
        {
            double num = double.Parse(Console.ReadLine());
            double pow = double.Parse(Console.ReadLine());

            Console.WriteLine(CalcPow(num, pow));
        }

        static double CalcPow(double num, double pow)
        {
            double result = Math.Pow(num, pow);
            return result;
        }
    }
}
