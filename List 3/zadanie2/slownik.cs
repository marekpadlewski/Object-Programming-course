using System;

namespace DictLibrary
{   
    public class slownik<K, V> where K : IComparable<K>
    {
        public slownik<K, V> next;
        public K key;
        public V val;

        public slownik()
        {
            next = null;
            key = default(K);
            val = default(V);
        }

        public void add(K key, V val)
        {
            if (next != null)
            {
                next.add(key, val);
            }
            else
            {
                next = new slownik<K, V>();
                next.key = key;
                next.val = val;
            }

        }

        public void delete(K key)
        {
            if (key.CompareTo(next.key) == 0)
            {
                Console.WriteLine("element usuwany - {0}", next.key);
                next = next.next;
            }
            else
            {
                if (next != null)
                    next.delete(key);
            }

        }

        public V find(K key)
        {
            
            slownik<K, V> current = this;
            while (!key.Equals(current.key))
            {
                current = current.next;

                if (current == null)
                {
                    Console.WriteLine("Nie znaleziono podanego klucza {0} w słowniku.", key);
                    return default(V);
                }
                    
            }
            
            Console.Write("Wartość dla klucza {0} wynosi: ", current.key);
            return current.val;
        }

        public void print()
        {
            if (next != null)
            {
                Console.WriteLine("{0} {1}", next.key, next.val);
                next.print();
            }
           
        }
    }
}