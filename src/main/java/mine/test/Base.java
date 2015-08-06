package mine.test;

public class Base {
	public static int count=0;
	public Base(){
		count++;
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		/**
		 * count������static����ʱ����base1��base2����count
		 * ���Ϊ1 2
		 * ȥ��static����
		 * ���Ϊ1 1
		 */
		Base  base1=new Base();
		System.out.println(base1.count);
		Base  base2=new Base();
		System.out.println(base2.count);
	}
}
