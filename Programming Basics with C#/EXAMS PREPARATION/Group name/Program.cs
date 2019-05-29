using System;
namespace Group_name
{
    class Program
    {
        static void Main()
        {
            char capital = char.Parse(Console.ReadLine());
            char firstSmall = char.Parse(Console.ReadLine());
            char secondSmall = char.Parse(Console.ReadLine());
            char thirdSmall = char.Parse(Console.ReadLine());
            char number = char.Parse(Console.ReadLine());
            int counter = -1; // за да не смята първата интерация

            for (int i = 'A'; i <= capital; i++)
            {
                for (int i1 = 'a'; i1 <= firstSmall; i1++)
                {
                    for (int i2 = 'a'; i2 <= secondSmall; i2++)
                    {
                        for (int i3 = 'a'; i3 <= thirdSmall; i3++)
                        {
                            for (int i4 = '0'; i4 <= number; i4++)
                            {
                                counter++;
                            }
                        }
                    }
                }
            }
            Console.WriteLine(counter);

        }
    }
}
