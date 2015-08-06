package mine.core.thread;

class SyncStack { // ͬ����ջ��
	private int index = 0; // ��ջָ���ʼֵΪ0
	private char[] buffer = new char[6]; // ��ջ��6���ַ��Ŀռ�

	public synchronized void push(char c) { // ���ϻ�����
		while (index == buffer.length) { // ��ջ����������ѹջ
			try {
				this.wait(); // �ȴ���ֱ�������ݳ�ջ
			} catch (InterruptedException e) {
			}
		}
		this.notify(); // ֪ͨ�����̰߳����ݳ�ջ
		buffer[index] = c; // ������ջ
		index++; // ָ�������ƶ�
	}

	public synchronized char pop() { // ���ϻ�����
		while (index == 0) { // ��ջ�����ݣ����ܳ�ջ
			try {
				this.wait(); // �ȴ������̰߳�������ջ
			} catch (InterruptedException e) {
			}
		}

		this.notify(); // ֪ͨ�����߳���ջ
		index--; // ָ�������ƶ�
		return buffer[index]; // ���ݳ�ջ
	}
}

class Producer implements Runnable { // ��������
	SyncStack theStack;

	// �����������ɵ���ĸ�����浽ͬ����ջ��

	public Producer(SyncStack s) {
		theStack = s;
	}

	public void run() {
		char c;
		for (int i = 0; i < 20; i++) {
			c = (char) (Math.random() * 26 + 'A');
			// �������20���ַ�
			theStack.push(c); // ���ַ���ջ
			System.out.println("Produced: " + c); // ��ӡ�ַ�
			try {
				Thread.sleep((int) (Math.random() * 1000));
				/* ÿ����һ���ַ��߳̾�˯�� */
			} catch (InterruptedException e) {
			}
		}
	}
}

class Consumer implements Runnable { // ��������
	SyncStack theStack;

	// ���������õ��ַ�������ͬ����ջ
	public Consumer(SyncStack s) {
		theStack = s;
	} 

	public void run() {
		char c;
		for (int i = 0; i < 20; i++) {
			c = theStack.pop(); // �Ӷ�ջ�ж�ȡ�ַ�
			System.out.println("Consumed: " + c);
			// ��ӡ�ַ�
			try {
				Thread.sleep((int) (Math.random() * 1000));
				/* ÿ��ȡһ���ַ��߳̾�˯�� */
			} catch (InterruptedException e) {
			}
		}
	}
}

public class SyncTest {
	public static void main(String args[]) {
		SyncStack stack = new SyncStack();
		// ��������������������������������������ͬһ��ͬ����ջ����
		Runnable source = new Producer(stack);
		Runnable sink = new Consumer(stack);
		Thread t1 = new Thread(source); // �߳�ʵ����
		Thread t2 = new Thread(sink); // �߳�ʵ����
		t1.start(); // �߳�����
		t2.start(); // �߳�����
	}
}