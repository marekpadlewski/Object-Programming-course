using System;

namespace PrimeCollection
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            PrimeCollection pc = new PrimeCollection();
            foreach(int p in pc)
                Console.WriteLine(p);
        }
    }
}