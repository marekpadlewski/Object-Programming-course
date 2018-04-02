using System;
using System.Collections;

namespace PrimeCollection
{
    public class Primes : IEnumerator
    {

        private int counter;

        private bool primeCheck(int number)
        {
            if (number < 2)
                return false;
            
            for (int i = 2; i <= Math.Sqrt(number); i++)
            {
                if (number % i == 0)
                    return false;
            }

            return true;
        }

        public Primes()
        {
            counter = 1;
        }

        public bool MoveNext()
        {
            counter++;

            while (!primeCheck(counter))
                counter++;

            return counter < 20;
        }

        public void Reset()
        {
            counter = 1;
        }


        public object Current
        {
            get => counter;
        }
    }
    
    class PrimeCollection : IEnumerable
    {
        public IEnumerator GetEnumerator()
        {
            return new Primes();
        }
    }
}