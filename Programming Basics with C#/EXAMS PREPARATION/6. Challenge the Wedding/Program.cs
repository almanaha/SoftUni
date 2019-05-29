using System;
class Program
{
    static void Main()
    {
        int men = int.Parse(Console.ReadLine());
        int women = int.Parse(Console.ReadLine());
        int tables = int.Parse(Console.ReadLine());

        int fullTables = 0;

        for (int i = 1; i <= men; i++)
        {
            for (int j = 1; j <= women; j++)
            {
                if (fullTables < tables)
                {
                    Console.Write($"({i} <-> {j}) ");
                }
                fullTables++;
            }
        }
    }
}

