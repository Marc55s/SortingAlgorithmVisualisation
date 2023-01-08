import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Algorithm {

    public static final int LINE_WIDTH = 3;
    private int height = 0;
    private int width = 0;
    private int startPosX = 0;
    private int startPosY = 0;
    int lastSorted = 0;
    int step = 0;
    private Integer[] data;

    public Algorithm(int startPosX, int startPosY, int width, int height){
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.width = width;
        this.height = height;
        generateData();
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        for (int i = 0; i < data.length; i++) {
            if (i == lastSorted) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }
            g.fillRect(startPosX + i * (LINE_WIDTH + 1), startPosY + height - data[i], LINE_WIDTH, data[i]);
        }
    }

    public abstract void algoStep();

    public void generateData() {
        data = new Integer[width / (LINE_WIDTH + 1)];
        for (int i = 0; i < data.length; i++) {
            data[i] =(int) ((i+1) * ((double)height/(double)(data.length-1)));
        }
        List<Integer> shuffle = Arrays.asList(data);
        Collections.shuffle(shuffle);
        shuffle.toArray(data);
    }

    public static boolean isSorted(Integer[] data){
        for (int i = 0; i < data.length-1; i++) {
            if(data[i] > data[i+1]){
                return false;
            }
        }
        return true;
    }


    public Integer[] getData() {
        return data;
    }

    public void setData(Integer[] data) {
        this.data = data;
    }
}
