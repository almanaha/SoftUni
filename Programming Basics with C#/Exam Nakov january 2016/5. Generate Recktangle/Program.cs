using System;
namespace _6.Generate_Rectangles
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int minArea = int.Parse(Console.ReadLine());

            bool printNo = true;

            for (int top = -n; top <= n; top++)
            {
                for (int left = -n; left <= n; left++)
                {
                    for (int bottom = top + 1; bottom <= n; bottom++)
                    {
                        for (int right = left + 1; right <= n; right++)
                        {
                            var width = right - left;
                            var heigth = bottom - top;
                            int area = width * heigth;

                            if (area >= minArea)
                            {
                                Console.WriteLine($"({left},{top}) ({right},{bottom}) -> {area}");
                                printNo = false;
                            }
                        }
                    }
                }
            }
            if (printNo)
            {
                Console.WriteLine("No");
            }
        }
    }
}
