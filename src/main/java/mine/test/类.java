package mine.test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import junit.framework.TestCase;

public class ��  extends TestCase{
	public int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) { 
		this.age = age; 
	}
	/**
	 * �ڲ����Ǵ�jdk1.1��ʼ����ģ��������ŵ㣺
	 * 1���ڲ�������ܷ����������˽�����Ժͷ���
	 * 2���ڲ����ܹ���������������������������ʣ����һ����ֻ��ĳ�����ṩʹ�ã����Զ�����Ϊ�ڲ���
	 * 3�������ڲ�����Է�������ڻص������У�����Ӧ����ͼ�α༭�е��¼�����
	 * �ص㣺
	 * 1���ڲ����������Ϊ�����࣬���Կ��Ա������ڲ���̳У�Ҳ��������Ϊfinal��
	 * 2�����ⲿ�಻ͬ�����ڲ����������Ϊprivate��protected���ⲿ��ֻ������Ϊpublic��default
	 * 3���ڲ����������Ϊstatic�ģ�����ͬ�ⲿ�෽��һ������ʹ���ⲿ��ķ�static����
	 * 4����static���ڲ����еĳ�Ա��������Ϊstatic��ֻ�����ⲿ���static�ڲ����в�������static��Ա
	 * @author Administrator
	 */
	class �ڲ���{
		public void getAge(){
			System.out.println(age);
		}
	}
	/**
	 * �ֲ��ڲ��������������ڵ�ǰ�����ڲ��ܱ�public��private�ȷ������η�����
	 */
	public void �ֲ��ڲ�����ķ���(){
		class �ֲ��ڲ���{
			public void �ֲ��ڲ����еķ���(){
				Date now=new Date();
				System.out.println(now.toGMTString());
			}
		}
		new �ֲ��ڲ���().�ֲ��ڲ����еķ���();
	}
	Frame frame=new Frame(); 
	/**
	 * �����ڲ�����ָ�ڶ���ʱû�����Ƶ��ڲ��࣬һ�����ڷ�����
	 * �����ڲ�����������ڱ���ʱ���е�
	 */
	public void �����ڲ���(){
		frame.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
