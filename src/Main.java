import javax.swing.JFrame;

public class Main implements Runnable {

    Thread thread;
    GamePanel gamePanel;
    JFrame frame;

    public Main() {
        frame = new JFrame();
        gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        startGameThread();
    }

    public static void main(String[] args) {
        new Main();
    }

    public void startGameThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double FPS = 30;
        double frames = 0;
        double timer = 0;
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (thread.isAlive()) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime -lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                gamePanel.update(delta);
                gamePanel.repaint();
                frames++;
                delta--;
            }
            if(timer >= 1_000_000_000){
                frame.setTitle("FPS: "+frames);

                timer = 0;
                frames = 0;
            }
        }
    }
}
