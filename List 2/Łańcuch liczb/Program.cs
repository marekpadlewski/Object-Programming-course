using System;

namespace Zadanie2
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            IntStream num = new IntStream();
            PrimeStream prim = new PrimeStream();
            RandomStream ran = new RandomStream();
            RandomWordStream rws = new RandomWordStream();

            Console.WriteLine("Strumień liczb naturalnych:");
            for (int i = 0; i < 5; i++)
                Console.WriteLine(num.next());

            Console.WriteLine("\nStrumień liczb pierwszych:");
            for (int i = 0; i < 5; i++)
                Console.WriteLine(prim.next());

            Console.WriteLine("\nStrumień liczb randomowych:");
            for (int i = 0; i < 5; i++)
                Console.WriteLine(ran.next());

            Console.WriteLine("\nStrumień stringów o długości kol. liczb pierwszych:");
            for (int i = 0; i < 5; i++)
                Console.WriteLine(rws.next());
        }
    }
}