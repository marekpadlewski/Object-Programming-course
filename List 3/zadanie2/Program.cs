using DictLibrary;
using System;

namespace main2
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            var Dictionary = new slownik<int, string>();

            Dictionary.add(13, "Metody");
            Dictionary.add(2, "Procedury");
            Dictionary.add(42, "Predykat");

            Console.WriteLine("Zawartość słownika:");
            Dictionary.print();
            Console.WriteLine();
            
            Console.WriteLine(Dictionary.find(13));
            
            Dictionary.delete(13);

            Console.WriteLine(Dictionary.find(13));
            
            Console.WriteLine("Zawartość słownika:");
            Dictionary.print();

            Console.Write(Dictionary.find(32));
        }
    }
}