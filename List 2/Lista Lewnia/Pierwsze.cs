using System.Collections.Generic;

namespace ConsoleApplication1
{
    public class Pierwsze : ListaLeniwa
    {
        private PrimeStream prime;
        private List<int> Lp;

        public Pierwsze()
        {
            prime = new PrimeStream();
            Lp = new List<int>();
        }

        public int next()
        {
            return prime.next();
        }

        public int element(int n)
        {
            if (n < lenght)
                return Lp[n];

            lenght = n;

            if (Lp.Count == 0)
                Lp.Add(next());

            for (int i = Lp.Count - 1; i < n; i++)
            {
                Lp.Add(next());
            }

            return Lp[n];
            
        }
    }

    public class IntStream
    {
        public int number;

        public IntStream()
        {
            number = 0;
        }

        public int next()
        {
            if (number == int.MaxValue)
                return 0;

            return number++;
        }
    }

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
    }
}