using System;
namespace _1.Dog_House
{
    class Program
    {
        static void Main()
        {
            double sideA = double.Parse(Console.ReadLine());
            double sideB = double.Parse(Console.ReadLine());

            double halfSideA = sideA / 2;
            double areaOfRoof = sideA * halfSideA * 2;

            double backSquareArea = halfSideA * halfSideA;
            double backTriangleArea = (halfSideA * (sideB - halfSideA)) / 2;
            double backArea = backSquareArea + backTriangleArea;

            double frontSquareArea = (sideA / 5) * (sideA / 5);
            double frontArea = backArea - frontSquareArea;

            double totalHouseArea = frontArea + backArea + areaOfRoof;

            double greenpaint = totalHouseArea / 3;
            double redPaint = areaOfRoof / 5;

            Console.WriteLine($"{greenpaint:F2}");
            Console.WriteLine($"{redPaint:F2}");

        }
    }
}
