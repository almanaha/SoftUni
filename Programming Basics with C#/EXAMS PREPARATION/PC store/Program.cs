using System;
namespace PC_store
{
    class Program
    {
        static void Main()
        {
            double cpuPrice = double.Parse(Console.ReadLine());
            double gpuPrice = double.Parse(Console.ReadLine());
            double ramPrice = double.Parse(Console.ReadLine());
            int ramCount = int.Parse(Console.ReadLine());
            double discount = double.Parse(Console.ReadLine());

            cpuPrice *= 1.57;
            gpuPrice *= 1.57;
            ramPrice *= 1.57;
            double sumOfRamPrice = ramPrice * ramCount;
            double cpuDiscount = cpuPrice - (cpuPrice * 0.05);
            double gpuDiscount = gpuPrice - (gpuPrice * 0.05);

            double totalPrice = sumOfRamPrice + cpuDiscount + gpuDiscount;

            Console.WriteLine($"Money needed - {totalPrice:F2} leva.");

        }
    }
}
