using System;
class Program
{
    static void Main()
    {
        int bitcoins = int.Parse(Console.ReadLine());
        double chineseMoney = double.Parse(Console.ReadLine());
        double commission = double.Parse(Console.ReadLine());

        double euro = (bitcoins * 1168 + chineseMoney * 0.15 * 1.76) / 1.95 - ((bitcoins * 1168 + chineseMoney * 0.15 * 1.76) / 1.95 * (commission / 100));

        Console.WriteLine(euro);
    }
}

