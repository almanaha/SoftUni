using System;
namespace _2.Changing_Tiles
{
    class Program
    {
        static void Main(string[] args)
        {
            double money = double.Parse(Console.ReadLine());

            double widthTile = double.Parse(Console.ReadLine());
            double lengthTile = double.Parse(Console.ReadLine());

            double sideOfTile = double.Parse(Console.ReadLine());
            double heigthOfTile = double.Parse(Console.ReadLine());

            double pricePerTile = double.Parse(Console.ReadLine());
            double moneyForWork = double.Parse(Console.ReadLine());

            double sizeOfFloor = widthTile * lengthTile;
            double sizeOfTile = (sideOfTile * heigthOfTile) / 2;
            double tilesNeeded = Math.Ceiling(sizeOfFloor / sizeOfTile) + 5;
            double totalSum = (tilesNeeded * pricePerTile) + moneyForWork;

            if (totalSum <= money)
            {
                double leftMoney = Math.Abs(totalSum - money);
                Console.WriteLine($"{leftMoney:F2} lv left.");
            }
            else
            {
                double moreMoney = Math.Abs(money - totalSum);
                Console.WriteLine($"You'll need {moreMoney:F2} lv more.");
            }

        }
    }
}
