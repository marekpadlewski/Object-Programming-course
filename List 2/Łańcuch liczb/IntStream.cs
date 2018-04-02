namespace Zadanie2
{
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

        public bool eos()
        {
            return number == int.MaxValue;
        }

        public void reset()
        {
            number = 0;
        }
    }
}