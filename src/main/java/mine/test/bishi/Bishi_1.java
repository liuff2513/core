package mine.test.bishi;

import junit.framework.TestCase;
/**
 * ��Ŀ��
 * 	��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
 * 	С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ�������
 * 	��һ����ÿ���µ���������Ϊ���٣�
 * @author Administrator
 *
 */
public class Bishi_1 extends TestCase{
	public void method1() {
		System.out.println("��1���µ����Ӷ�����1");
		System.out.println("��2���µ����Ӷ�����1");
		int c1=1,c2=1,c,m=12;
		for(int i=3;i<=m;i++){
			c = c2;
			/*�ϸ��µ����Ӷ���*/
			/*ÿ�����Ӻ�������ܶ���*/
			c2 = c1 + c2;
			/*ÿ��Ҫ���ӵ����Ӷ���*/
			c1 = c; 
			System.out.println(c+"--"+c1+"--"+c2);
//			System.out.println("��" + i + "���µ����Ӷ���: " + c2);
		}
	}
	public void method2(){
		/**
		 * �ӵ�3���º��������ó����¹��ɣ�
		 * 	    ��������Ӷ���     ���������Ӷ���    �������Ӷ���
		 * 3-      1			    0			  1
		 * 4-	   1				1			  1
		 * 5-	   2				1			  2
		 * 6-	   3				2			  3		
		 * .........
		 * ���Ͽɵ�֪,ÿ���µĳ�������Ӻ����������Ӷ�����һ���ģ�����Ϊ�������µ��ܺ�
		 * �����������Ӷ������ɺ������һ��������Ҫ�ȳ������һ���¿�ʼ��
		 */
		int u1=0,u2=1,u=1,count;
		for(int i=3;i<=12;i++){
			count=2*u+u1;
			u=u1+u2;
			u1=u2;
			u2=u;
			System.out.println("��"+i+"���µ����Ӷ�����"+count);
		}
	}
}
