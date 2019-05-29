using System;
namespace Stupid_Password_Generator_6_March_2016
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var l = int.Parse(Console.ReadLine());

            for (int num1 = 1; num1 <= n; num1++)
            {
                for (int num2 = 1; num2 <= n; num2++)
                {
                    for (var letter1 = 'a'; letter1 < 'a' + l; letter1++)
                    {
                        for (var letter2 = 'a'; letter2 < 'a' + l; letter2++)
                        {
                            var max = Math.Max(num1, num2);

                            for (int num3 = max + 1; num3 <= n; num3++)
                            {
                                Console.Write("{0}{1}{2}{3}{4} ", num1, num2, letter1, letter2, num3);
                            }
                        }
                    }
                }
            }
        }
    }
}
