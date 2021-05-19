package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Swj
 * @date 2021/5/19 15:18
 */
class BounceFrame extends JFrame {
    private final BallComponer comp;
    public static final int STEPS = 1000;//这条语句声明了一个公有的静态的常量值RESULT_CODE 并且初始化值为1000
    public static final int DELAY = 3;

    public BounceFrame() {
        setTitle("Bounce");
        comp = new BallComponer();//为窗体或者自定义控件，创建一个可以“存放”其他控件（如按钮、文本框等等）的容器。
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
        try {
            Ball ball = new Ball();
            comp.add(ball);

            for (int i = 1; i <= STEPS; i++) {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
