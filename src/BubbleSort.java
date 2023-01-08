public class BubbleSort extends Algorithm {

    public BubbleSort(int startPosX, int startPosY, int width, int height) {
        super(startPosX, startPosY, width, height);
    }

    @Override
    public void algoStep() {
        Integer[] data = getData();
        if (isSorted(data)) return;
        for (int i = 0; i < getData().length-1; i++) {
            if (data[i] > data[i + 1]) {
                int temp = data[i + 1];
                data[i + 1] = data[i];
                data[i] = temp;
                lastSorted = i + 1;
            }
        }
    }
}
