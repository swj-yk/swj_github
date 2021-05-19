package bounce;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class BallComponer extends JPanel {
	private static final int DEFAULT_WIDTH = 450;//图形宽450
	private static final int DEFAULT_HEIGHT = 350;//图形高350

	//工具类Ball大于balls时实例一个数组
	private final java.util.List<Ball> balls = new ArrayList<>();
	
	public void add(Ball b) {//添加的类
		balls.add(b);//添加一个b的值
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);//调用父类方法
		Graphics2D g2 = (Graphics2D) g;//g2d 是一个变量，也可以看做是对象；
		for (Ball b : balls) {//遍历balls把值赋值给b
			g2.fill(b.getShape());
		}
	}
	
	public Dimension getPreferredSize() {//获取组的首选大小，因为布局管理器会根据组件自动调整框架窗口的大小
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);//实例当前的窗口的长宽
	}
}
