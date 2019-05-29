using System;
namespace Old_Books
{
    class Program
    {
        static void Main()
        {
            string book = Console.ReadLine();
            int capacity = int.Parse(Console.ReadLine());

            bool foundTheBook = false;
            int bookCount = 0;

            while (true)
            {
                string input = Console.ReadLine();
                if(input == book)
                {
                    foundTheBook = true;
                    break;
                }
                bookCount++;
                if(bookCount == capacity)
                {
                    break;
                }
            }
            if (foundTheBook)
            {
                Console.WriteLine($"You checked {bookCount} books and found it.");
            }
            else
            {
                Console.WriteLine("The book you search is not here!");
                Console.WriteLine($"You checked {bookCount} books.");
            }
        }
    }
}
