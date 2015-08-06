package mine.core.pictureCheckCode.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreatePictureCheckCode {
	public static void getPictureCheckCode(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		int width=86;//ָ����֤��Ŀ��
		int height=22;//ָ����֤��ĸ߶�
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		Graphics g=image.getGraphics();
		Graphics2D g2d=(Graphics2D)g;//����Graphics2D����
		
		Random ran=new Random();
		Font mFont=new Font("����",Font.BOLD,16);//����һ������ʽ
		
		g.setColor(RandColor.getRandColor(200, 255));
		g.fillRect(0, 0, width, height);//���Ʊ���
		g.setFont(mFont);
		g.setColor(RandColor.getRandColor(180, 200));//��������
		
		//����100����ɫ��λ��ȫ��Ϊ���������������������Ϊ2f
		for(int i=0;i<100;i++){
			int x=ran.nextInt(width-1);
			int y=ran.nextInt(height-1);
			int x1=ran.nextInt(6)+1;
			int y1=ran.nextInt(12)+1;
			BasicStroke bs=new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
			Line2D line=new Line2D.Double(x,y,x+x1,y+y1);
			g2d.setStroke(bs);
			g2d.draw(line);//����ֱ��
		}
		String sRand="";
		//����������֤����
		String ctmp="";
		int itmp=0;
		for(int i=0;i<4;i++){
//			ran=new Random(new Date().getTime()+i);
			switch(ran.nextInt(4)){
				case 1://����A~Z����ĸ
					itmp=ran.nextInt(26)+65;
					ctmp=String.valueOf((char)itmp);
					break;
				case 2://���ɺ���
					String[] rBase={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
					//���ɵ�һλ������
					int r1=ran.nextInt(3)+11;//����11~14֮��������
					String str_r1=rBase[r1];
					//���ɵ�2λ������
					int r2;
					if(r1==13){
						r2=ran.nextInt(7);//����0~7֮��������
					}else{
						r2=ran.nextInt(16);//����0~16֮��������
					}
					String str_r2=rBase[r2];
					//���ɵ�1λ��λ��
					int r3=ran.nextInt(6)+10;//����10~16֮��������
					String str_r3=rBase[r3];
					//���ɵ�2λ��λ��
					int r4;
					if(r3==10){
					r4=ran.nextInt(15)+1;//����1~16֮��������
					}else if(r3==15){
						r4=ran.nextInt(15);//����1~15֮��������
					}else{
						r4=ran.nextInt(16);//����0~16֮��������
					}
					String str_r4=rBase[r4];
					//�����ɵĻ�����ת��Ϊ����
					byte[] bytes=new byte[2];
					//�����ɵ����뱣�浽�ֽ�����ĵ�1��Ԫ����
					String str_r12=str_r1+str_r2;
					int tempLow=Integer.parseInt(str_r12,16);
					bytes[0]=(byte)tempLow;
					//�����ɵ�λ�뱣�浽�ֽ�����ĵ�2��Ԫ����
					String str_r34=str_r3+str_r4;
					int tempHigh=Integer.parseInt(str_r34, 16);
					bytes[1]=(byte)tempHigh;
					ctmp=new String(bytes);//�����ֽ��������ɺ���
					break;
				default:
					itmp=ran.nextInt(10)+48;
					ctmp=String.valueOf((char)itmp);
					break;
			}
			sRand+=ctmp;
			Color color=new Color(20+ran.nextInt(110),20+ran.nextInt(110),20+ran.nextInt(110));
			g.setColor(color);
			//��������תָ���Ƕ�
			Graphics2D g2d_word=(Graphics2D) g;
			AffineTransform trans=new AffineTransform();
			trans.rotate(ran.nextInt(45)*3.14/180,15*i+8,7);
			//��������
			float scaleSize=ran.nextFloat()+0.8f;
			if(scaleSize>1f)
				scaleSize=1f;
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
			g.drawString(ctmp, 15*i+18, 14);
		}
		//�����ɵ���֤�뱣�浽Session�С�
		HttpSession session=request.getSession(true);
		session.setAttribute("randCheckCode", sRand);
		//������ɵ���֤��ͼƬ
		g.dispose();//disponse������ �ͷŴ�ͼ�ε��������Լ���ʹ�õ�����ϵͳ��Դ
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
}
