using System;

namespace Kolekcje
{
    public class slownik<K, V> where K : IComparable<K>, CollectionsIF
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
            Console.WriteLine("Podaj klucz i wartość: ");
           
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

        public void write()
        {
            if (next != null)
            {
                Console.WriteLine("{0} {1}", next.key, next.val);
                next.write();
            }
        }

        public bool isEmpty()
        {
            return next == null;
        }
    }
    
    public class Node<T>
    {
        public T value;
        public Node<T> next;
        public Node<T> prev;

        public Node()
        {
            next = null;
            prev = null;
            value = default(T);
        }
    }
    
    public class Lista<T> : CollectionsIF
    {
        public Node<T> head;
        public Node<T> end;

        public Lista()
        {
            head = null;
            end = null;
        }
        
        public void add(T x)
        {
            if (end == null)
            {
                end = new Node<T>();
                end.value = x;
                if (head != null)
                {
                    head.next = end;
                    end.prev = head;
                }
            }
            else
            {
                Node<T> y = new Node<T>();
                y.value = x;
                y.next = null;
                end.next = y;
                y.prev = end;
                end = y;
            }
        }

        public void delete()
        {
            
            if (isEmpty())
            {
                Console.WriteLine("Lista jest pusta! Nie mogę usunąć elementu.");
            }
            
            
            end.prev.next = null;
            end = end.prev;
        }

        public bool isEmpty()
        {
            return head == null && end == null;
        }

        public void write()
        {
            Node<T> temp = head;
            
            while (temp != null)
            {
                Console.Write(temp.value + " ");
                temp = temp.next;
            }
            Console.WriteLine();
        }
    }
}