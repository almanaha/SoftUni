using System;
class Exam
{
    static void Main()
    {
        int budget = int.Parse(Console.ReadLine());
        int total = 0;
        while (true)
        {
            string i = Console.ReadLine();
            if (i == "Stop")
            {
                int diff = budget - total;
                Console.WriteLine($"Money left: {diff}");
                break;
            }
            foreach (char item in i)
            {
                int letter = (int)item;
                total += letter;
            }
            if (budget <= total)
            {
                Console.WriteLine("Not enough money!");
                break;
            }
            else
            {
                Console.WriteLine("Item successfully purchased!");
                budget -= total;
                total = 0;
            }
        }
    }

}
