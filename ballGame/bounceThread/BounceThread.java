package bounceThread;

import javax.swing.*;
import java.awt.*;

public class BounceThread {
	public static void main(String[] atgs) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new bounceThread.BounceFrame();
			frame.setTitle("BounceThread");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

