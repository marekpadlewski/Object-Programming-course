using System;
using System.ComponentModel;
using ClassLibrary1;

namespace main
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Lista<int> lista = new Lista<int>();
            
            lista.addBack(5);
            lista.addFront(1);
            lista.addBack(9);
            lista.addBack(42);
            lista.addFront(17);
            Console.WriteLine("Lista po dodaniu pięciu wartości: ");
            lista.writeNodes();

            Console.WriteLine("Lista po usunięciu elementu z końca: ");            
            lista.delBack();
            lista.writeNodes();

            Console.WriteLine("Lista po usunięciu elementu z początku: ");
            lista.delFront();
            lista.writeNodes();

            lista.delBack();
            lista.writeNodes();
            
            lista.addBack(7);
            lista.writeNodes();
            lista.delBack();
            lista.writeNodes();

        }
    }
}