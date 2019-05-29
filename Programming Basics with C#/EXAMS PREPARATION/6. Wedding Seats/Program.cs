using System;
class Program
{
    static void Main()
    {
        char symbol = char.Parse(Console.ReadLine());
        int countOfRows = int.Parse(Console.ReadLine());
        int oddSeats = int.Parse(Console.ReadLine());

        int evenSeats = oddSeats + 2; // oddSeats are -2

        int counter = 0;

        for (char sector = 'A'; sector <= symbol; sector++)
        {
            for (int row = 1; row <= countOfRows; row++)
            {
                if (row % 2 == 0)
                {
                    for (char seat = 'a'; seat < evenSeats + 97; seat++)
                    {
                        Console.WriteLine($"{sector}{row}{seat}");
                        counter++;
                    }
                }
                else
                {
                    for (char seat = 'a'; seat < oddSeats + 97; seat++)
                    {
                        Console.WriteLine($"{sector}{row}{seat}");
                        counter++;
                    }
                }
            }
            countOfRows++; // От конзолата се чете броят на редовете в първия сектор (A), като във всеки следващ сектор редовете се увеличават с 1
        }
        Console.WriteLine(counter);
    }
}

