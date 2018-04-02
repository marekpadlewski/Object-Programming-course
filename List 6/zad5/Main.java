public class Main {

    public static void main(String[] args){

        int A[] = {1, 7, 4, 9, 10, 0, 17, 42};

        MergeSort sort = new MergeSort(A, 0, A.length);

        sort.start();

        try{
            sort.join();
        }
        catch (Exception e){}

        for (int i = 0 ; i < A.length ; i++){
            System.out.print(A[i] + " ");
        }
    }
}
