using System;
namespace Arrow
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            int width = n + 5;
            Console.WriteLine(new string('_', width / 2) + "^" + new string('_', width / 2));
            Console.WriteLine(new string('_', width / 2 - 1) + "/|\\" + new string('_', width / 2 - 1));

            int underScores = width / 2 - 2;
            int dots = 0;

            for (int i = 0; i < n / 2; i++)
            {
                Console.WriteLine(new string('_',underScores) + '/' + new string('.',dots) + "|||" +
                    new string('.', dots) + "\\" + new string('_', underScores));
                dots++;
                underScores--;
            }

            Console.WriteLine(new string ('_', width / 2 - 4) + '/' + ".." +
                "|||" + ".." + '\\' + new string('_', width / 2 - 4));
            Console.WriteLine(new string('_', width / 2 - 3) + '/' + "." +
                "|||" + "." + '\\' + new string('_', width / 2 - 3));

            for (int i = 0; i < n; i++)
            {
                Console.WriteLine(new string('_', width / 2 - 1) + "|||" +
                    new string('_', width / 2 - 1));
            }
            Console.WriteLine(new string('_', width / 2 - 1) + "~~~" +
                new string('_', width / 2 - 1));

            dots = 0;
            underScores = width / 2 - 2;

            for (int i = 0; i < n / 2; i++)
            {
                Console.WriteLine(new string('_',underScores) + "//" +
                    new string('.',dots) + "!" + new string('.', dots) + "\\\\" +
                    new string('_', underScores));
                underScores--;
                dots++;
            }
        }
    }
}
