using System;

namespace Zadanie2
{
    public class RandomStream : IntStream
    {
        public Random rnd = new Random();

        public int next()
        {
            return rnd.Next(0, int.MaxValue);
        }

        public bool eos()
        {
            return false;
        }
    }
}