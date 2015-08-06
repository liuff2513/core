package mine.core.thread;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class Clock extends Applet implements Runnable{
	Thread clockThread;
	/**
	 * �÷�����Applet�ķ����������̵߳ķ���
	 */
	@Override
	public void start() {
		if(clockThread==null){
			/*�߳�����Clock�������߳�����Ϊ"Clock"*/
			clockThread=new Thread(this, "Clock");
			/*�����߳�*/
			clockThread.start();
		} 
	}
	public void paint(Graphics g){
		Date now=new Date();
		g.drawString(now.getHours() + ":" + now.getMinutes()+ ":" +now.getSeconds(), 5, 10);
	}
	@Override
	public void run() {
		while(clockThread!=null){
			repaint();//ˢ����ʾ����
		}
		try {
			/*˯��1�룬��ÿ��1��ִ��һ��*/
			clockThread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �÷�����Applet�ķ����������̵߳ķ���
	 */
	@Override
	public void stop() {
		clockThread.stop();
		clockThread=null;
	}
}
