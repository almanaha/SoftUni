using System;
namespace Building
{
    class Program
    {
        static void Main()
        {
            int floors = int.Parse(Console.ReadLine());
            int rooms = int.Parse(Console.ReadLine());

            for (int currentFloor = floors; currentFloor >= 1; currentFloor--)
            {
                for (int currentRoom = 0; currentRoom < rooms; currentRoom++)
                {
                    if(currentFloor == floors)
                    {
                        Console.Write($"L{currentFloor}{currentRoom} ");
                        continue;
                    }
                    else if(currentFloor % 2 == 1)
                    {
                        Console.Write($"A{currentFloor}{currentRoom} ");
                    }
                    else
                    {
                        Console.Write($"O{currentFloor}{currentRoom} ");
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
