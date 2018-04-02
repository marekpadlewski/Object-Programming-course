using System;

namespace ConsoleApplication1
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            ListaLeniwa ls = new ListaLeniwa();
            Console.WriteLine("Lista leniwa: ");
            Console.WriteLine("Element 40: " + ls.element(40));
            Console.WriteLine("Rozmiar listy: " + ls.size());
            Console.WriteLine("Element 30: " + ls.element(30));
            Console.WriteLine("Rozmiar listy: " + ls.size());
            Console.WriteLine("Element 50: " + ls.element(50));
            Console.WriteLine("Rozmiar listy: " + ls.size());
            Console.WriteLine("Element 40: " + ls.element(40));
            Console.WriteLine("Rozmiar listy: " + ls.size());
            Console.WriteLine("Element 0: " + ls.element(0));
            Console.WriteLine("Rozmiar listy: " + ls.size());

            Pierwsze pi = new Pierwsze();
            Console.WriteLine("\nLista liczb pierwszych: ");
            Console.WriteLine(pi.element(0));
            Console.WriteLine(pi.element(1));
            Console.WriteLine(pi.element(2));
            Console.WriteLine(pi.element(5));
            Console.WriteLine(pi.element(40));
            Console.WriteLine(pi.element(2));
        }
    }
}