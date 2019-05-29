using System;
namespace _04.Bachelor_Party
{
    class Program
    {
        static void Main()
        {
            int singerPrice = int.Parse(Console.ReadLine());
            int total = 0;
            int group = 0;
            int guests = 0;

            for (int i = 0; ; i++)
            {
                string command = Console.ReadLine().ToLower();
                if (command =="the restaurant is full")
                {
                    break;
                }

                group = int.Parse(command);
                if (group <= 4)
                {
                    total += group * 100;
                }
                else
                {
                    total += group * 70;
                }
                guests += group;
            }
            if (total >= singerPrice)
            {
                Console.WriteLine($"You have {guests} guests and {total-singerPrice} leva left.");
            }
            else
            {
                Console.WriteLine($"You have {guests} guests and {total} leva income, but no singer.");
            }
            
        }
    }
}
