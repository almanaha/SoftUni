using System;
class exam
{
    static void Main()
    {
        double baklavaPrice = double.Parse(Console.ReadLine());
        double muffinsPrice = double.Parse(Console.ReadLine());
        double shtolenKg = double.Parse(Console.ReadLine());
        double sweetsKg = double.Parse(Console.ReadLine());
        int biscuitsKg = int.Parse(Console.ReadLine());

        double shtolenPrice = shtolenKg * (baklavaPrice * 1.6);
        double sweetsPrice = sweetsKg * (muffinsPrice * 1.8);
        double biscuitsPrice = biscuitsKg * 7.5;
        double total = shtolenPrice + sweetsPrice + biscuitsPrice;
        Console.WriteLine($"{total:F2}");
    }
}

