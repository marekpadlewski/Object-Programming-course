public class Main1 {

    public static void main(String[] args) {

        Tree <Integer> t = new Tree<>(5);


        t.add(1);
        t.add(42);
        t.add(2);
        t.add(8);
        t.add(17);
        t.add(9);
        System.out.println(t.print());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.print());

        t.add(3);
        t.add(2);
        t.add(11);
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
        System.out.println(t.getVal());
    }
}
