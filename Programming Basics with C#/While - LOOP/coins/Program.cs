using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace coins
{
    class Program
    {
        static void Main(string[] args)
        {
            double change = double.Parse(Console.ReadLine());
            change = change * 100;
            int changeToInt = (int)change;
            int coins = 0;

            while(change >= 200)
            {
                change -= 200;
                coins++;
            }
            if(change >= 100)
            {
                change -= 100;
                coins++;
            }
            if (change >= 50)
            {
                change -= 50;
                coins++;
            }
            while (change >= 20)
            {
                change -= 20;
                coins++;
            }
            if (change >= 10)
            {
                change -= 10;
                coins++;
            }
            if (change >= 5)
            {
                change -= 5;
                coins++;
            }
            while (change >= 2)
            {
                change -= 2;
                coins++;
            }
            if (change >= 1)
            {
                change -= 1;
                coins++;
            }
            Console.WriteLine(coins);




            //while(changeToInt > 0)
            //{
            //    if(changeToInt >= 200)
            //    {
            //        changeToInt = changeToInt - 200;
            //    }
            //    else if(changeToInt >= 100)
            //    {
            //        changeToInt = changeToInt - 100;
            //    }
            //    else if(change >= 50)
            //    {
            //        changeToInt = changeToInt - 50;
            //    }
            //    else if (changeToInt >= 20)
            //    {
            //        changeToInt = changeToInt - 20;
            //    }
            //    else if (changeToInt >= 10)
            //    {
            //        changeToInt = changeToInt - 10;
            //    }
            //    else if (changeToInt >= 5)
            //    {
            //        changeToInt = changeToInt - 5;
            //    }
            //    else if (changeToInt >= 2)
            //    {
            //        changeToInt = changeToInt - 2;
            //    }
            //    else if (changeToInt >= 1)
            //    {
            //        changeToInt = changeToInt - 1;
            //    }
            //    coins++;
            //}
            //Console.WriteLine(coins);
        }
    }
}
