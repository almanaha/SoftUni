using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Number_sequence
{
    class Program
    {
        static void Main(string[] args)
        {
            int greatest = int.MinValue;
            int smallest = int.MaxValue;
            while(true)
            {
                string input = Console.ReadLine();
                if (input == "END"){break; }

                int inputToNumber = int.Parse(input);
                if (inputToNumber > greatest)
                {
                    greatest = inputToNumber;
                }
                if (inputToNumber < smallest)
                {
                    smallest = inputToNumber;
                }
            }
            Console.WriteLine($"Max number: {greatest}");
            Console.WriteLine($"Min number: {smallest}");
        }
    }
}
