public class MergeSort extends Thread{

    private int array[], start, end;
    private static int min = 2;

    public MergeSort(int array[], int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

    private void merge(int temp[]){

        int i = start;
        int j = end / 2;
        int k = 0;

        while(i < end / 2 && j < end){

            if (array[i] < array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }

        while(i < end / 2){
            temp[k++] = array[i++];
        }

        while (j < end){
            temp[k++] = array[j++];
        }

        System.arraycopy(array, start, temp, 0, end - start);
    }

    private void insertSort()
    {
        for (int i = start; i < end; i++)
        {
            int j, val = array[i];

            for (j = i - 1; j >= 0; j--) {

                if (array[j] <= val)
                    break;

                array[j + 1] = array[j];
            }

            array[j + 1] = val;
        }
    }

    public void run(){

        int tempArr[] = new int[end];

        if ((end - start) < min) {
            insertSort();
            return;
        }


        MergeSort sort1 = new MergeSort(array, start, start + (end-start)/2);
        MergeSort sort2 = new MergeSort(array,start + (end-start)/2, end);

        sort1.start();
        sort2.start();

        try{
            sort1.join();
            sort2.join();
        }

        catch (Exception e){}

        merge(tempArr);
    }
}
