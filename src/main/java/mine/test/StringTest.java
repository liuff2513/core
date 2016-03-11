package mine.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import junit.framework.TestCase;

public class StringTest extends TestCase{
	public static void main(String[] args) {
		ActionListener listener=new StringBufferInnerClass();
		Timer timer=new Timer(3000, listener);
		timer.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
class StringBufferInnerClass implements ActionListener{
	StringBuffer buffer;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(buffer==null)
			buffer=new StringBuffer();
		buffer.append("\n增加了一行");
		System.out.println(buffer);
		Date now=new Date();
		System.out.println("At the tone,the time is "+now+" ");
		
	}
}
class StringBuilderInnerClass {
	
}
