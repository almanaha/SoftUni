using System;

class WeddingPresents
{
    static void Main(string[] args)
    {
        double guestsCount = double.Parse(Console.ReadLine());
        double giftsCount = double.Parse(Console.ReadLine());

        double totalPercentage = (giftsCount / guestsCount) * 100;

        double percentA = 0;
        double percentB = 0;
        double percentV = 0;
        double percentG = 0;

        for (int i = 1; i <= giftsCount; i++)
        {
            string symbol = Console.ReadLine();
            switch (symbol)
            {
                case "A": percentA++; break;
                case "B": percentB++; break;
                case "V": percentV++; break;
                case "G": percentG++; break;
            }
        }
        percentA = (percentA / giftsCount) * 100;
        percentB = (percentB / giftsCount) * 100;
        percentV = (percentV / giftsCount) * 100;
        percentG = (percentG / giftsCount) * 100;
        
        Console.WriteLine($"{percentA:F2}%");
        Console.WriteLine($"{percentB:F2}%");
        Console.WriteLine($"{percentV:F2}%");
        Console.WriteLine($"{percentG:F2}%");
        Console.WriteLine($"{totalPercentage:F2}%");
        
    }
}

