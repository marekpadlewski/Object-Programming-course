using System.Collections.Generic;

namespace Zadanie2
{
    public class PrimeStream : IntStream
    {
        List<int> primes = new List<int>();

        public PrimeStream()
        {

            bool[] tab = new bool[10000000];

            for (int i = 2; i < 10000000; i++) 
                tab[i] = true;

            for (int i = 2; i * i <= 10000000; i++)
            {
                if (tab[i]) 
                    for (int j = i * i; j < 10000000; j += i)
                        tab[j] = false;
            }

            for (int i = 2; i < 10000000; i++) 
                if (tab[i]) 
                    primes.Add(i);
        }

        public int next()
        {
            return primes[base.next()];
        }

        public bool eos()
        {
            return base.next() == 10000000;
        }
    }
}