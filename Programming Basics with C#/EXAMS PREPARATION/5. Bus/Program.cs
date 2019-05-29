using System;
 
namespace _1.Bus
{
    class Program
    {
        static void Main()
        {
            //ЗАДАЧА ОТ ИЗПИТ- АПРИЛ 2018
            int startPeople = int.Parse(Console.ReadLine());
            int stops = int.Parse(Console.ReadLine());

            int lastPeople = 0;

            for (int counter = 1; counter <= stops; counter++)
            {
                //counter = отброява броя на спирките, на които автобуса спира
                //numberPeopleOut - броя на пъниците, които слизат; numberPeopleComing - броя на пътниците, които се качват
                int peopleOut = int.Parse(Console.ReadLine());
                int peopleIn = int.Parse(Console.ReadLine());

                if (counter == 1)
                {
                    //тук слагаме условие ако спирката е първа, тъй като при първа спирка за да намерим хората,
                    //които са останали в буса, трябва да извадим тези, които са слезли и да прибавим тези, които са се качили,
                    //като ги изваждаме от ХОРАТА,с които ПЪРВОНАЧАЛНО(numberPeopleInBegining) е тръгнал автобуса,
                    //а после трябва да ги изваждаме от хората, които са ОСТАНАЛИ(peopleNumberFinished) в последствие;
                    lastPeople = (startPeople - peopleOut) + peopleIn + 2;
                }
                else if (counter % 2 == 0)
                {
                    //когато спирката е четна и после, когато не е четна
                    lastPeople = (lastPeople - peopleOut - 2) + peopleIn;
                }
                else if (counter % 2 != 0)
                {
                    lastPeople = (lastPeople - peopleOut) + peopleIn + 2;
                }
            }

            Console.WriteLine($"The final number of passengers is : {lastPeople}");
        }
    }
}