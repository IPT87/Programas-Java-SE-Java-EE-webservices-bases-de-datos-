package principal;

import java.util.Calendar;
import java.util.Locale;

public class TestCalendar {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance(new Locale("es"));
		System.out.println("Dia de la semana: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("Año: " + calendar.get(Calendar.YEAR));
		System.out.println("Mes: " + calendar.get(Calendar.MONTH));
		System.out.println("Dia del mes: " + calendar.get(Calendar.DAY_OF_MONTH));
	}

}
