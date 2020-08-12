import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

class DateParse{
	
	public static void main(String[] args) throws ParseException {
		Date dt = new Date();
		//int year = 1900;
		
		
		final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); //2010 11 11 11 12 14.456+0700 //2020 08 10 08 34 28.28+0000
        f.setTimeZone(TimeZone.getTimeZone("UTC"));
        String signedDate=f.format(new Date());
        System.out.println(signedDate);
        
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss.SSSXXX");
		String str = "20201231031911.456+05:30";
		System.out.println(str.length());
		
		dt = formatter.parse(str);
		
		System.out.println("----------");
		System.out.println(dt.getYear() + 1900);
		System.out.println(dt.getMonth());
		System.out.println(dt.getDate());
		System.out.println(dt.getHours());
		System.out.println(dt.getMinutes());
		System.out.println(dt.getSeconds());
		System.out.println(dt.getDay());
		System.out.println(dt.getTimezoneOffset());
		
		
		System.out.println(dt.getTime());
		
		/*
		 * DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE; String new_str =
		 * dtf.format(str); System.out.println(new_str);
		 */
		//Calendar cd = Calendar.getInstance();
		
		
		
		
	}
	
	
}