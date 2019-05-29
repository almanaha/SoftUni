using System;
namespace Football_Souvenirs
{
    class Program
    {
        static void Main()
        {
            string team = Console.ReadLine();
            string souvenir = Console.ReadLine();
            int boughtSouvenirs = int.Parse(Console.ReadLine());
            double totalMoney = 0;

            switch (team)
            {
                case "Argentina":
                    switch (souvenir)
                    {
                        case "flags": totalMoney = boughtSouvenirs * 3.25; break;
                        case "caps": totalMoney = boughtSouvenirs * 7.20; break;
                        case "posters": totalMoney = boughtSouvenirs * 5.10; break;
                        case "stickers": totalMoney = boughtSouvenirs * 1.25; break;
                        default: Console.WriteLine("Invalid stock!"); break;
                    } break;
                case "Brazil":
                    switch (souvenir)
                    {
                        case "flags": totalMoney = boughtSouvenirs * 4.20; break;
                        case "caps": totalMoney = boughtSouvenirs * 8.50; break;
                        case "posters": totalMoney = boughtSouvenirs * 5.35; break;
                        case "stickers": totalMoney = boughtSouvenirs * 1.20; break;
                        default: Console.WriteLine("Invalid stock!"); break;
                    } break;
                case "Croatia":
                    switch (souvenir)
                    {
                        case "flags": totalMoney = boughtSouvenirs * 2.75; break;
                        case "caps": totalMoney = boughtSouvenirs * 6.90; break;
                        case "posters": totalMoney = boughtSouvenirs * 4.95; break;
                        case "stickers": totalMoney = boughtSouvenirs * 1.10; break;
                        default: Console.WriteLine("Invalid stock!"); break;
                    } break;
                case "Denmark":
                    switch (souvenir)
                    {
                        case "flags": totalMoney = boughtSouvenirs * 3.10; break;
                        case "caps": totalMoney = boughtSouvenirs * 6.50; break;
                        case "posters": totalMoney = boughtSouvenirs * 4.80; break;
                        case "stickers": totalMoney = boughtSouvenirs * 0.90; break;
                        default: Console.WriteLine("Invalid stock!"); break;
                    }
                    break;
                default: Console.WriteLine("Invalid country!"); break;
            }
            if (totalMoney != 0)
            {
                Console.WriteLine($"Pepi bought {boughtSouvenirs} {souvenir} of {team} for {totalMoney:F2} lv.");
            }
        }
    }
}
