using System;

class Program
{
    static void Main()
    {
        int m = int.Parse(Console.ReadLine());
        int n = int.Parse(Console.ReadLine());
        int l = int.Parse(Console.ReadLine());
        int specialNum = int.Parse(Console.ReadLine());
        int controlNum = int.Parse(Console.ReadLine());
        bool isTrue = false;

        for (int i = m; i > 0; i--)
        {
            for (int k = n; k > 0; k--)
            {
                for (int g = l; g > 0; g--)
                {
                    int number = m * 100 + n * 10 + 1;
                    if (number % 3 == 0)
                    {
                        specialNum += 5;
                    }
                    else if (l == 5)
                    {
                        specialNum -= 2;
                    }
                    else if (number % 2 == 0)
                    {
                        specialNum *= 2;
                    }

                    if (specialNum >= controlNum)
                    {
                        isTrue = true;
                        break;
                    }
                }
                if (isTrue) break;
            }
            if (isTrue) break;
        }
        if (isTrue)
        {
            Console.WriteLine($"Yes! Control number was reached! Current special number is {specialNum}.");
        }
        else
        {
            Console.WriteLine($"No! {specialNum} is the last reached special number.");
        }
    }
}

