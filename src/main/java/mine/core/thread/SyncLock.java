package mine.core.thread;

public class SyncLock {
	int idx=0; //��ջָ��ĳ�ʼֵΪ0
	char[ ] data = new char[6]; //��ջ��6���ַ��Ŀռ�

	public void push(char c){ //ѹջ����
		synchronized (this) {//this��ʾStack�ĵ�ǰ����
			data[idx] = c; //������ջ
			idx++; //ָ�������ƶ�һλ
		} 
	}
	public char pop(){ //��ջ����
		synchronized (this) {//this��ʾStack�ĵ�ǰ����
			idx--; //ָ�������ƶ�һλ
			return data[idx]; //���ݳ�ջ
		}
	}
}
