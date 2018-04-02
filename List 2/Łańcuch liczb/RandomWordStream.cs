using System;

namespace Zadanie2
{
    public class RandomWordStream : PrimeStream
    {
        public string next()
        {
            string x = "";
            int len = base.next();

            for (int i = 0; i < len; i++)
            {
                x += RandomLetter.GetLetter();
            }

            return x;
        }
    }

    static class RandomLetter
    {

        static Random random = new Random();
        public static char GetLetter()
        {
            int num = random.Next(0, 26);
            char let = (char)('a' + num);
            return let;
        }
    }
}