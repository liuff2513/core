package mine.core.pictureCheckCode.util;

import java.awt.Color;
import java.util.Random;

/**
 * ���������ɫ
 * @author Administrator
 *
 */
public class RandColor {
	public static  Color getRandColor(int s,int e){
		Random ran=new Random();
		if(s>255)
			s=255;
		if(e>255)
			e=255;
		int r=s+ran.nextInt(e-s);//�������RGB��ɫ�е�rֵ
		int g=s+ran.nextInt(e-s);//�������RGB��ɫ�е�gֵ
		int b=s+ran.nextInt(e-s);//�������RGB��ɫ�е�bֵ
		return new Color(r,g,b);
	}
}
