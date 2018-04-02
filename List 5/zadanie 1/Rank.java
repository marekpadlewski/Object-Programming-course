
public abstract class Rank implements Comparable<Rank> {

    protected static enum _Rank{
        MAJOR(100),
        SERGEANT(50),
        PRIVATE(1);

        private int numVal;

        _Rank(int v) {
            this.numVal = v;
        }

        public int getVal() {
            return numVal;
        }

    }

    _Rank rank;

    @Override
    public int compareTo(Rank t) {
        return this.rank.getVal() - t.rank.getVal();
    }

    public String toString() {
        return this.rank+"";
    }

}