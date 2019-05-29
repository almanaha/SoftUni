using System;
class Program
{
    static void Main()
    {
        double change = double.Parse(Console.ReadLine());
        change *= 100;

        int hundreds = (int)change / 100;
        int tens = (int)change / 10 % 10;
        int ones = (int)change % 10;

        int counter = 0;

        while (true)
        {
            if (hundreds == 0 && tens == 0 && ones == 0)
            {
                break;
            }

            if (hundreds - 2 >= 0)
            {
                hundreds -= 2;
                counter++;
                continue;
            }
            if (hundreds - 1 >= 0)
            {
                hundreds -= 1;
                counter++;
                continue;
            }

            if (tens - 5 >= 0)
            {
                hundreds -= 5;
                counter++;
                continue;
            }
            if (tens - 2 >= 0)
            {
                hundreds -= 2;
                counter++;
                continue;
            }
            if (tens - 1 >= 0)
            {
                hundreds -= 1;
                counter++;
                continue;
            }
            if (ones - 5 >= 0)
            {
                ones -= 5;
                counter++;
                continue;
            }
            if (ones - 2 >= 0)
            {
                ones -= 2;
                counter++;
                continue;
            }
            if (ones - 1 >= 0)
            {
                ones -= 1;
                counter++;
                continue;
            }
        }
        Console.WriteLine(counter);
    }
}
