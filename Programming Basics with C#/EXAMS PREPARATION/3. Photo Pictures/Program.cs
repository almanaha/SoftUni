using System;
class Program
{
    static void Main()
    {
        int pictures = int.Parse(Console.ReadLine());
        string type = Console.ReadLine();
        string order = Console.ReadLine();

        double priceForOne = 0;
        double totalForAll = 0;

        switch (type)
        {
            case "9X13": priceForOne = 0.16;
                totalForAll = priceForOne * pictures;
                if (pictures > 50)
                {
                    totalForAll *= 0.95;
                }break;
            case "10X15": priceForOne = 0.16;
                totalForAll = priceForOne * pictures;
                if (pictures > 80)
                {
                    totalForAll *= 0.97;
                }
                break;
            case "13X18": priceForOne = 0.38;
                totalForAll = priceForOne * pictures;
                if (pictures >= 50 && pictures <= 100)
                {
                    totalForAll *= 0.97;
                }
                else if(pictures > 100)
                {
                    totalForAll *= 0.95;
                }break;
            case "20X30": priceForOne = 2.90;
                totalForAll = priceForOne * pictures;
                if (pictures >= 10 && pictures <= 50)
                {
                    totalForAll *= 0.93;
                }
                else if (pictures > 50)
                {
                    totalForAll *= 0.91;
                }break;
        }

        if (order == "online")
        {
            totalForAll *= 0.98;
        }
        Console.WriteLine($"{totalForAll:F2}BGN");
    }
}

