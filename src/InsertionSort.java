import java.util.Arrays;

public class InsertionSort extends Algorithm {

    /**
     * InsertionSort worst runtime in Big-O-notation is equal to O(n²)
     * Best case: O(n²)
     */


    public InsertionSort(int startPosX, int startPosY, int width, int height) {
        super(startPosX,startPosY,width,height);
    }

    @Override
    public void algoStep() {
        Integer[] data = getData();
        if(isSorted(data)) return;
        for (int i = 1; i < step; i++) {
            int value = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > value) {
                data[j + 1] = data[j];
                j--;
                data[j + 1] = value;
                lastSorted = j+1;
            }
        }
        setData(data);
        step++;
    }
}
