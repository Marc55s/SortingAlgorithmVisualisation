import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    InsertionSort insertionSort;
    BubbleSort bubbleSort;
    BogoSort bogoSort;
    QuickSort quickSort;

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        initAlgos();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        insertionSort.render(g);
        bubbleSort.render(g);
        bogoSort.render(g);
    }

    public void update(double delta) {
       insertionSort.algoStep();
       bubbleSort.algoStep();
       bogoSort.algoStep();

    }


    private void initAlgos() {
        insertionSort = new InsertionSort(0,0,WIDTH,HEIGHT/3);
        bubbleSort = new BubbleSort(0,HEIGHT/3,WIDTH,HEIGHT/3);
        bogoSort = new BogoSort(0,2*HEIGHT/3,WIDTH/2,HEIGHT/3);
        quickSort = new QuickSort(0,2*HEIGHT/3,WIDTH,HEIGHT/3);

    }


}