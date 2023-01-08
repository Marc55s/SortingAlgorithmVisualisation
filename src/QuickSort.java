import java.util.Arrays;

public class QuickSort extends Algorithm {

    public QuickSort(int startPosX, int startPosY, int width, int height) {
        super(startPosX, startPosY, width, height);
    }

    @Override
    public void algoStep() {
        setData(sort(0, getData().length - 1));
    }

    private Integer[] sort(int l, int r) {
        Integer[] data = getData();
        int q;
        if (l < r) {
            q = partition(data, l, r);
            sort(l, q);
            sort(q + 1, r);
        }
        return data;
    }

    private int partition(Integer[] data, int l, int r) {
        int i, j, x = data[(l + r) / 2];
        i = l - 1;
        j = r + 1;
        do {
            i++;
        } while (data[i] < x);
        do {
            j--;
        } while (data[j] > x);
        if (i < j) {
            int k = data[i];
            data[i] = data[j];
            data[j] = k;
        } else {
            return j;
        }
        return -1;
    }
}
