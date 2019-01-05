package demo;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;
import java.math.*;

@SuppressWarnings("unused")
public class MyPanel extends JPanel implements MouseListener,MouseMotionListener
//public class MyPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int nMouseX=-1,nMouseY=-1;
	int nMouseShiftX=-1,nMouseShiftY=-1;
	ArrayList<ball> b;
	int x,y,xr,yr;
	MyPanel(ArrayList<ball> b)
	{
		this.setBounds(0, 0, 1366, 768);
		this.setBackground(null);
		this.setOpaque(false);
		this.b=b;
//		this.addMouseMotionListener(this);
		System.out.println("panel已创建");
	}
	public void paint(Graphics g)
	{
		try 
		{
			super.paint(g);
			for(int i=0;i<b.size();i++)
			{
				x=(int)(b.get(i).x-(b.get(i).l/2));
				y=(int)(b.get(i).y-(b.get(i).l/2));
				xr=(int)b.get(i).l;
				yr=(int)b.get(i).l;
				g.drawImage(b.get(i).img.get((int) b.get(i).nowimg), x,y,xr,yr, null);
			}
			this.repaint();
		} 
		catch (Exception e) 
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		System.out.println("鼠标拖拽");
		System.exit(0);
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		//重写，监听到此动作，执行以下语句退出程序
		if((this.nMouseX<0)||(this.nMouseY<0))
		{
			this.nMouseX = e.getX();
			this.nMouseY = e.getY();
		}
		else
		{
			this.nMouseShiftX = Math.abs(e.getX() - this.nMouseX);
			this.nMouseShiftY = Math.abs(e.getY() - this.nMouseY);
			System.out.println("鼠标移动:"+"x="+this.nMouseShiftX+"y="+this.nMouseShiftY);
			if((this.nMouseShiftX+this.nMouseShiftY)>=2)
			{
				System.exit(0);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("鼠标点击");
		System.exit(0);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("鼠标进入");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("鼠标退出");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("鼠标按压");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("鼠标释放");
	}

}
