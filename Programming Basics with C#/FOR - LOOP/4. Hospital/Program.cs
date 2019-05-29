using System;
class Program
{
    static void Main()
    {
        int days = int.Parse(Console.ReadLine());

        int patientsIn = 0;
        int patientsOut = 0;
        int doctors = 7;

        for (int day = 1; day <= days; day++)
        {
            int patients = int.Parse(Console.ReadLine());
            if (day % 3 == 0 && patientsIn < patientsOut)
            {
                doctors++;
            }
            if (patients <= doctors)
            {
                patientsIn += patients;
            }
            else
            {
                int totalUntreated = patients - doctors;
                patientsOut += totalUntreated;
                patientsIn += doctors;
            }

        }
        Console.WriteLine($"Treated patients: {patientsIn}.");
        Console.WriteLine($"Untreated patients: {patientsOut}.");
    }
}

