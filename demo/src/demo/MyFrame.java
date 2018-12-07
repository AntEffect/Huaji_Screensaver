package demo;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class MyFrame extends JFrame
{
	MyPanel panel;
	public static final int width=1366;
	public static final int height=768;

	//背景图片+++++add 2018-12-04
	ImageIcon Background;
	JLabel BackgroundLabel;
	
	public MyFrame(int x,int y,ArrayList<ball> b)
	{
		//设置背景图片
		Background=new ImageIcon("demo/Husky.jpg");
		BackgroundLabel=new JLabel(Background);
		BackgroundLabel.setLayout(null);
		BackgroundLabel.setBounds(0, 0, Background.getIconWidth(),Background.getIconHeight());
		JLayeredPane BackgroundLayeredPane=this.getLayeredPane();
		BackgroundLayeredPane.add(BackgroundLabel);
		BackgroundLayeredPane.setLayer(BackgroundLabel,-1000);
		
		
//		this.setBackground(Color.green);
		this.setUndecorated(true);
		
		try 
		{
			this.setBounds(x, y, width, height);
			panel=new MyPanel(b);
			this.add(panel);
			this.setVisible(true);
//			this.setOpacity(1000);
			this.setResizable(false);
//			this.setLocationRelativeTo(null);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH );
		} 
		catch (Exception e) 
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
//		this.getContentPane().setBackground(Color.green);
		this.getContentPane().add(BackgroundLabel);
//		this.getContentPane().setVisible(false);
		//注1：ContentPane在LayeredPane上，控件默认加载在ContentPane上
		//注2：控件的添加顺序会对显示造成遮挡
		//注3：JFrame会自动生成默认的ContentPane和LayerPane
		//注4：象棋里面是用自己写的透明chessPanel控件set为ContentPane
	}
}
