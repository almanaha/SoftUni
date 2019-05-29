using System;
class Program
{
    static void Main()
    {
        string ftm = "dd-MM-yyyy";
        string value = Console.ReadLine();
        DateTime userBirthday = DateTime.ParseExact(value, ftm, null);
        Console.WriteLine(userBirthday.AddDays(1000).ToString("dd-MM-yyyy"));
    }
}

