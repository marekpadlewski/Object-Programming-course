using System;
using System.Collections.Generic;

namespace ConsoleApplication1
{
    public class ListaLeniwa
    {
        public int lenght;
        private List<int> L;
        private Random ran;

        public ListaLeniwa()
        {
            lenght = 0;
            L = new List<int>();
            ran = new Random();
        }

        public int size()
        {
            return lenght;
        }

        private int next()
        {
            return ran.Next();
        }

        public int element(int n)
        {
            if (n < lenght)
                return L[n];

            lenght = n;

            if (L.Count == 0)
                L.Add(next());

            for (int i = L.Count - 1; i < n; i++)
            {
                L.Add(next());
            }

            return L[n];
        }
    }

}