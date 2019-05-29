using System;
namespace Vacation
{
    class Program
    {
        static void Main()
        {
            double moneyForVacation = double.Parse(Console.ReadLine());
            double currentMoney = double.Parse(Console.ReadLine());

            string action = string.Empty;
            double transaction = default(double);

            double count = 0;
            int spendCount = 0;
            int daysCount = 0;
            string result = string.Empty;

            while (true)
            {
                action = Console.ReadLine();
                transaction = double.Parse(Console.ReadLine());
                daysCount++;

                if(action == "spend")
                {
                    spendCount++;
                    count = currentMoney - transaction;
                    currentMoney -= transaction;
                    if(count < 0)
                    {
                        currentMoney = 0;
                    }
                }
                else if(action == "save")
                {
                    spendCount = 0;
                    currentMoney += transaction;
                }
                if (spendCount == 5)
                {
                    result = $"You can't save the money." + Environment.NewLine + daysCount;

                    break;
                }
                if(currentMoney >= moneyForVacation)
                {
                    result = $"You saved the money for {daysCount} days.";
                        break;
                }
            }
            Console.WriteLine(result);
        }
    }
}
