using System;
class Program
{
    static void Main()
    {
        int magic = int.Parse(Console.ReadLine());

        for (int one = 1; one <= 9; one++)
        {
            for (int two = 1; two <= 9; two++)
            {
                for (int three = 1; three <= 9; three++)
                {
                    for (int four = 1; four <= 9; four++)
                    {
                        for (int five = 1; five <= 9; five++)
                        {
                            for (int six = 1; six <= 9; six++)
                            {
                                int product = one * two * three * four * five * six;
                                if (product == magic)
                                {
                                    Console.Write($"{one}{two}{three}{four}{five}{six} ");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

