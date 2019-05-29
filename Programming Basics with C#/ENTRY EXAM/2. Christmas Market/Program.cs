using System;
class Exam
{
    static void Main()
    {
        double money = double.Parse(Console.ReadLine());
        double fantasyBooks = double.Parse(Console.ReadLine());
        double horrorBooks = double.Parse(Console.ReadLine());
        double loveBooks = double.Parse(Console.ReadLine());

        double book1 = fantasyBooks * 14.90;
        double book2 = horrorBooks * 9.80;
        double book3 = loveBooks * 4.30;

        double totalSum = book1 + book2 + book3;
        double sumAfterTaxes = totalSum * 0.8;
        if (sumAfterTaxes >= money)
        {
            double diff = sumAfterTaxes - money;
            double workerCut = Math.Floor(diff * 0.1);
            double donation = (diff - workerCut) + money;
            Console.WriteLine($"{donation:F2} leva donated.");
            Console.WriteLine($"Sellers will receive {workerCut} leva.");
        }
        else
        {
            double diff = money - sumAfterTaxes;
            Console.WriteLine($"{diff:F2} money needed.");
        }
    }
}
