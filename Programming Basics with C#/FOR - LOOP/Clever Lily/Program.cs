using System;
namespace Clever_Lily
{
    class Program
    {
        static void Main()
        {
            int age = int.Parse(Console.ReadLine());
            double washingMachine = double.Parse(Console.ReadLine());
            int toyPrice = int.Parse(Console.ReadLine());

            int toysCounter = 0;
            int moneyFromGifts = 0;
            int badBrother = 0;

            for (int i = 1; i <= age; i++)
            {
                if (i % 2 ==0)
                {
                    badBrother++;
                    moneyFromGifts += 10 * badBrother;
                }
                else
                {
                    toysCounter++;
                }
            }
            int moneyForToys = toysCounter * toyPrice;
            int totalMoney = (moneyForToys + moneyFromGifts) - badBrother;
            if (totalMoney >= washingMachine)
            {
                Console.WriteLine($"Yes! {(totalMoney-washingMachine):F2}");
            }
            else
            {
                Console.WriteLine($"No! {(washingMachine-totalMoney):F2}");
            }
        }
    }
}
