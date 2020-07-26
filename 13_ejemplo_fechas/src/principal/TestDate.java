package principal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDate {

	public static void main(String[] args) {
		Date fecha = new Date();
		System.out.println(fecha);
		System.out.println(fecha.getTime());
		
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, new Locale("es"));
		System.out.println(df.format(fecha));
		
		SimpleDateFormat sdt = new SimpleDateFormat("YY-dd-MM HH:mm");
		System.out.println(sdt.format(fecha));
		
		// parseado de fechas
		SimpleDateFormat personalizado = new SimpleDateFormat("dd-MM-yyyy");
		String miFecha = "25-12-2020";
		try {
			Date miDate = personalizado.parse(miFecha);
			System.out.println(miDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
