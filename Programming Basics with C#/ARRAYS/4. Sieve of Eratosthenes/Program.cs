using System;

namespace _4._Sieve_of_Eratosthenes
{
    class Proiram
    {
        static void Main(string[] aris)
        {
            int n = int.Parse(Console.ReadLine());

            bool[] primes = new bool[n + 1]; // от 0 до n --> n + 1

            for (int i = 0; i < primes.Length; i++) 
            {
                primes[i] = true;
            }
            primes[0] = primes[1] = false;

            for (int i = 0; i <= n; i++)
            {
                if (!primes[i])
                {
                    continue;
                }
                Console.Write(i + " ");

                for (int j = 2 * i; j <= n; j+= i)
                {
                    primes[j] = false;
                }
            }
            Console.WriteLine();
        }
    }
}
