package bounceThread;

import bounce.Ball;
import bounce.BallComponer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Swj
 * @date 2021/5/19 15:32
 */
class BounceFrame extends JFrame {
    private final BallComponer comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 5;

    public BounceFrame() {
        comp = new BallComponer();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r = () -> {
            try {
                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.repaint();
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}
