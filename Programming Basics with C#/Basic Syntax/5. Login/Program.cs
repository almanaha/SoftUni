using System;
namespace _5.Login
{
    class Program
    {
        static void Main()
        {
            string username = Console.ReadLine();
            string pass = string.Empty;

            for (int i = username.Length-1; i >= 0; i--)
            {
                pass += username[i];
            }
            int counter = 0;
            while (true)
            {
                string input = Console.ReadLine();
                if (input == pass)
                {
                    Console.WriteLine($"User {username} logged in.");
                    return;
                }
                else if (counter == 3)
                {
                    Console.WriteLine($"User {username} blocked!");
                    return;
                }
                else
                {
                    Console.WriteLine("Incorrect password. Try again.");
                }
                counter++;
            }
        }
    }
}
