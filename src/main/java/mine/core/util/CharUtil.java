package mine.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;
/**
 * ���ݹ���GB2312-80�涨��
 * 	1�����й��꺺�ּ��ַ�������һ��94�С�94�еķ�����
 * 	2������ÿһ�г���һ������ÿһ�г���һ��λ����Ŷ�Ϊ01��94
 * 	3��������ÿһ�����ֺͷ������ڵ����ź�λ�������һ���4�����������־������ǵġ���λ�롱
 * 	4���κ�һ�����ֻ���Ŷ���Ӧ��Ψһ��һ����λ��
 * 01����15����ͼ�η���������
 * 	1��01����09��Ϊ��׼������
 * 	2��10����15��Ϊ�Զ��������
 * 16����55����һ�����ú���������
 * 	1������3755��һ������
 *  2����40�����ĺ����ǰ�����ƴ������ģ�ͬ���ְ��ʻ�˳������
 *  3������55����90~94λδ���庺��
 * 56����87������������������
 * 	1������3008������
 *  2������������
 * 88����94�����Զ��庺��������
 * 	1����10~15�����Զ�����ź͵�88~94�����Զ��庺�ֿ������û����ж����������δ����ķ��źͺ���
 * 		
 * @author Administrator
 *
 */
public class CharUtil {
	private static Random random=new Random();
	public static String getChar(){
		String cTemp="";
		String[] rTemp={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
		//���ɵ�1λ������
		int r1=random.nextInt(3)+11;//����11~14֮��������
		String str_r1=rTemp[r1];
		//���ɵ�2λ������
		int r2;
		if(r1==11){
			r2=random.nextInt(7);//����0~7֮��������
		}else{
			r2=random.nextInt(16);//����0~16֮��������
		}
		String str_r2=rTemp[r2];
		//���ɵ�1λ��λ��
		int r3=random.nextInt(6)+10;//����10~16֮��������
		String str_r3=rTemp[r3];
		//���ɵ�2λ��λ��
		int r4;
		if(r3==10){
			r4=random.nextInt(15)+1;
		}else if(r3==15){
			r4=random.nextInt(15);
		}else{
			r4=random.nextInt(16);
		}
		String str_r4=rTemp[r4];
		//����������ɵ������λ�����ɺ���
		byte[] bytes=new byte[2];
		//�����ɵ����뱣�����ֽ�����ĵ�1��Ԫ����
		String str_12=str_r1+str_r2;
		int tempLow=Integer.parseInt(str_12, 16);
		bytes[0]=(byte) tempLow;
		//�����ɵ�λ�뱣�����ֽ�����ĵ�2��Ԫ����
		String str_34=str_r3+str_r4;
		int tempHigh=Integer.parseInt(str_34, 16);
		bytes[1]=(byte)tempHigh;
		//�����ֽ��������ɺ���
		try {
			cTemp=new String(bytes,"GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(tempLow+"---"+tempHigh);
		System.out.println(bytes[0]+"---"+bytes[1]);
//		System.out.println(r1+"-"+r2+"-"+r3+"-"+r4);
//		System.out.println(str_r1+"-"+str_r2+"-"+str_r3+"-"+str_r4);
		System.out.println(cTemp);
		return cTemp;
	}
	public static void main(String[] args) {
//		int i=0;
//		String str="";
//		while(true){
////			System.out.println(getChar());
//			System.out.println("---------- "+i);
//			str+=getChar();
//			i++;
//			if(i==100){
//				break;
//			}
//		}
//			
//		System.out.println(str);
		int i, j;
		System.out.println("start����");
		for (i = 1; i <= 94; i++) {
			for (j = 1; j <= 94; j++) {
				try {
					System.out.print(new String(new byte[] { (byte) -(byte)i, (byte) -(byte)j },
							"GB2312"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------------------------------");
		}
		System.out.println("end����");
	}
	
}
