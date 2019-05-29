using System;
class Program
{
    static void Main()
    {
        int singerPrice = int.Parse(Console.ReadLine());

        int money = 0;
        int countOfPeople = 0;

        while (true)
        {
            string command = Console.ReadLine();
            if (command == "The restaurant is full")
            {
                break;
            }
            int group = int.Parse(command);
            countOfPeople += group;
            if (group <= 4)
            {
                money += group * 100;
            }
            else
            {
                money += group * 70;
            }
        }

        if (singerPrice <= money)
        {
            int moneyLeft = money - singerPrice;
            Console.WriteLine($"You have {countOfPeople} guests and {moneyLeft} leva left.");
        }
        else
        {
            Console.WriteLine($"You have {countOfPeople} guests and {money} leva income, but no singer.");
        }
    }
}

