using System;
namespace _3.Online_Education
{
    class Program
    {
        static void Main()
        {
            string studyingForm1 = Console.ReadLine().ToLower();
            int students1 = int.Parse(Console.ReadLine());
            string studyingForm2 = Console.ReadLine().ToLower();
            int students2 = int.Parse(Console.ReadLine());
            string studyingForm3 = Console.ReadLine().ToLower();
            int students3 = int.Parse(Console.ReadLine());

            int sumOnline = 0;
            int sumOnsite = 0;
            int sum = 0;

            switch (studyingForm1)
            {
                case "online": sumOnline += students1; break;
                case "onsite": sumOnsite += students1; break;
            }
            switch (studyingForm2)
            {
                case "online": sumOnline += students2; break;
                case "onsite": sumOnsite += students2; break;
            }
            switch (studyingForm3)
            {
                case "online": sumOnline += students3; break;
                case "onsite": sumOnsite += students3; break;
            }

            if (sumOnsite > 600)
            {
                sumOnline += sumOnsite - 600;
                sumOnsite = 600;
            }
            sum = sumOnline + sumOnsite;

            Console.WriteLine("Online students: {0}", sumOnline);
            Console.WriteLine("Onsite students: {0}", sumOnsite);
            Console.WriteLine("Total students: {0}", sum);
        }
    }
}
