package mine.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.TestCase;

public class DateUtil extends TestCase{
	public void test1() throws ParseException{
		String str="2014��5��";
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy��MM��");
		Date date=dateFormat.parse(str);
		SimpleDateFormat resultFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String result=resultFormat.format(date);
		System.out.println(date.getMonth());
		System.out.println(result);
	}
}
