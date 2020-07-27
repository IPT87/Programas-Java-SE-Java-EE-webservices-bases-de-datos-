package principal;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;

public class TestPeriodo {

	public static void main(String[] args) {
		long f1 = 20389488995L;
		long f2 = 255342367290L;
		LocalDateTime ld = LocalDateTime.ofInstant(Instant.ofEpochMilli(f1), ZoneId.systemDefault());
		LocalDateTime ld2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(f2), ZoneId.systemDefault());
		/*Period period = Period.between(ld,  ld2);
		System.out.println(period);
		System.out.println("Dias: " + period.getDays());*/
		Duration duration = Duration.between(ld, ld2);
		System.out.println(duration);
		System.out.println("Dias: " + duration.toDays());
	}

}
