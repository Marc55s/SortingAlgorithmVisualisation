import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BogoSort extends Algorithm {

    public BogoSort(int startPosX, int startPosY, int width, int height) {
        super(startPosX, startPosY, width, height);
    }

    @Override
    public void algoStep() {
        Integer[] data = getData();
        if(isSorted(data))return;
        List<Integer> list = Arrays.asList(data);
        Collections.shuffle(list);
        list.toArray(data);
    }
}
