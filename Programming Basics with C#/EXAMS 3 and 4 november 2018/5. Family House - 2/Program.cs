using System;
namespace _5.Family_House___2
{
    class Program
    {
        static void Main()
        {
            var months = int.Parse(Console.ReadLine());
            var el = 0m;
            var water = 0m;
            var net = 0m;
            var other = 0m;
            var sumAll = 0m;
            for (int i = 1; i <= months; i++)
            {
                var sum = 0m;
                var elBill = decimal.Parse(Console.ReadLine());
                el += elBill;
                sum += elBill;
                water += 20;
                sum += 20;
                net += 15;
                sum += 15;
                other += (sum + sum * 0.2m);
                sum += (sum + sum * 0.2m);
                sumAll += sum;
            }
            Console.WriteLine($"Electricity: {el:F2} lv");
            Console.WriteLine($"Water: {water:F2} lv");
            Console.WriteLine($"Internet: {net:F2} lv");
            Console.WriteLine($"Other: {other:F2} lv");
            Console.WriteLine($"Average: {sumAll / months:F2} lv");
        }
    }
}
