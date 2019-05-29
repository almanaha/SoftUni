using System;
class Exam
{
    static void Main()
    {
        int adults = 0;
        int kids = 0;

        while (true)
        {
            string command = Console.ReadLine();
            if (command == "Christmas")
            {
                break;
            }
            int age = int.Parse(command);
            if (age <= 16)
            {
                kids++;
            }
            else
            {
                adults++;
            }
        }
        int toysPrice = kids * 5;
        int sweatersPrice = adults * 15;
        Console.WriteLine($"Number of adults: {adults}");
        Console.WriteLine($"Number of kids: {kids}");
        Console.WriteLine($"Money for toys: {toysPrice}");
        Console.WriteLine($"Money for sweaters: {sweatersPrice}");
    }
}
