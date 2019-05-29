using System;
namespace Slot_Machine
{
    class Program
    {
        static void Main()
        {
            char firstSymbol = char.Parse(Console.ReadLine());
            int firstNum = int.Parse(Console.ReadLine());
            char secondSymbol = char.Parse(Console.ReadLine());
            int secondNum = int.Parse(Console.ReadLine());
            char thirdSymbol = char.Parse(Console.ReadLine());
            int thirdNum = int.Parse(Console.ReadLine());

            firstSymbol = (char)(firstSymbol + firstNum);
            secondSymbol = (char)(secondSymbol + secondNum);
            thirdSymbol = (char)(thirdSymbol + thirdNum);

            //string result = firstSymbol + "" + secondSymbol + thirdSymbol;

            if (firstSymbol == '@' && secondSymbol == '@' && thirdSymbol == '@')
            {
                Console.WriteLine($"{firstSymbol}{secondSymbol}{thirdSymbol}");
                Console.WriteLine("!!! YOU LOSE EVERYTHING !!!");
            }
            else if (firstSymbol == '7' && secondSymbol == '7' && thirdSymbol == '7')
            {
                Console.WriteLine($"{firstSymbol}{secondSymbol}{thirdSymbol}");
                Console.WriteLine("*** JACKPOT ***");
            }
            else
            {
                Console.WriteLine($"{firstSymbol}{secondSymbol}{thirdSymbol}");
            }
        }
    }
}
