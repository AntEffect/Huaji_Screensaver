package demo;

//import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

public class init 
{
public static void main(String[] args) throws IOException 
{
	ArrayList<ball> balls=new ArrayList<ball>();
	ArrayList<Image> ballimg=new ArrayList<Image>();
	
	try
	{
		ballimg.add(ImageIO.read(new File("demo/src/img/huaji2.png")));
		ballimg.add(ImageIO.read(new File("demo/src/img/huaji4.png")));
		ballimg.add(ImageIO.read(new File("demo/src/img/huaji3.png")));
	}
	catch(IIOException e)
	{
		System.out.println("未找到文件");
	}
	
	MyFrame a=new MyFrame(0,0,balls);
//	a.setType(MyFrame.Type.UTILITY);
//	GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(a);
	for(int i=0;i<15;i++)
	{
		int ballsize=(int) (Math.random()*(300-30)+30);
		balls.add(new npcball(
				(int)(Math.random()*(MyFrame.width-ballsize/2-15-ballsize/2)+ballsize/2),
				(int)(Math.random()*(MyFrame.height-ballsize/2-35-ballsize/2)+ballsize/2),
				ballimg,
				ballsize,
				(int)(Math.random()*(5-4)+1),//Velocity
				Math.random()*(90),
				(Math.random()*1000)%2==0?1:-1,
				(Math.random()*1000)%2==0?1:-1)
		);
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	}
}
	/*MyThread a=new MyThread();
	a.start();*/