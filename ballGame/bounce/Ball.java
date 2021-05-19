package bounce;

//java.awt.geom提供用于在与二维几何形状相关的对象上定义和执行操作的 Java 2D 类。
import java.awt.geom.*;

//定义一个Ball类实体类
public class Ball {

	private static final int XSIZE = 15;//XSIZE图形本身的长
	private static final int YSIZE = 15;// YSIZE 图形本身的宽
	private double x = 0;//x 图形所在的横坐标
	private double y = 0;//y 图形所在的纵坐标
	private double dx = 1;//dx,图形的移动“速度”，即每个运行周期中图形移动速度的x分量
	private double dy = 1;//dy 图形的移动“速度”，即每个运行周期中图形移动速度的y分量

	//构造一个新 Rectangle2D，并将其初始化为：位置 (0, 0)、大小 (0, 0)
	public void move(Rectangle2D bounds) {
		x += dx;
		y += dy;
		if (x < bounds.getMinX()) {//当x值大于小于当前界限继续执行
			x = bounds.getMinX();
			dx = -dx;
		}
		if (x + XSIZE >= bounds.getMaxX()) {//当当前值大于等于的时候最大值减图像长
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		if (y < bounds.getMinY()) {
			y = bounds.getMinY();
			dy = -dy;
		}
		if (y + YSIZE >= bounds.getMaxY()) {//当当前值大于等于的时候最大值减图像宽
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}
	
	public Ellipse2D getShape() {//实例当前的图像x y 轴 图像的长宽
		return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
	}
}