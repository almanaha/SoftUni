using System;

class Everest
{
    static void Main(string[] args)
    {
        int days = 1;
        int meters;
        int result = 5364;
        string sleep;
        int everest = 8848;
        bool isFirstDaySleep = true;

        while (true)
        {
            sleep = Console.ReadLine();
            if (sleep =="END")
            {
                break;
            }

            meters = int.Parse(Console.ReadLine());

            if (sleep == "Yes")
            {
                if (isFirstDaySleep)
                {
                    days++;
                    isFirstDaySleep = false;
                }
                else
                {
                    days++;
                    isFirstDaySleep = false;
                }
            }
            else
            {
                isFirstDaySleep = false;
            }

            result += meters;

            if (days > 5)
            {
                result -= meters;
                break;
            }
            if (result >= everest)
            {
                break;
            }
        }

        if (result >= everest && days <= 5)
        {
            Console.WriteLine($"Goal reached for {days} days!");
        }
        else
        {
            Console.WriteLine("Failed!");
            Console.WriteLine(result);
        }
    }
}
