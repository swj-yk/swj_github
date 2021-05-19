package bounce;

import javax.swing.*;
import java.awt.*;

public class Bounce {//创建一个 Bounce类
	public static void main(String[] args)
	{
		EventQueue.invokeLater( () -> {//你只需要invokeLater在你想从另一个不是UI线程的线程（事件分派线程）更新你的UI时使用。
			JFrame frame = new BounceFrame();//就是用来创建一个窗体对象实例w。JFrame是java类库提供的类，用来创建图形界面窗体。
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//使用 System exit 方法退出应用程序。仅在应用程序中使用。
			frame.setVisible(true);//如果窗口是第一次显示，将事先初始化窗口显示的相关资源再显示；
		});
	}
}

