package localTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*        int time = LocalTime.of(1, 30).plusMinutes(690).getHour();
        System.out.println(time);
        System.out.println(LocalTime.parse("00:20:15").minusSeconds(615));

        LocalTime time2 = LocalTime.parse(scanner.next());
        System.out.println(time2.withSecond(0));*/
/*        LocalDateTime dateTime = LocalDateTime.parse(scanner.next());
        //System.out.println(dateTime.minusHours(scanner.nextInt()).plusMinutes(scanner.nextInt()));
        //System.out.println(dateTime.plusHours(11).toLocalDate());
        LocalDateTime dateTime2 = LocalDateTime.of(dateTime.getYear(), 1, 1, 0, 0);
        long hours = ChronoUnit.HOURS.between(dateTime2, dateTime);
        System.out.println(hours);*/
        //System.out.println(LocalDateTime.of(2020, 12, 31, 23, 59, 59).minusYears(1));
        Duration duration = Duration.of(75, ChronoUnit.MINUTES);
        System.out.println(duration.subtractFrom(LocalTime.of(20, 2, 22)));
        Period period  = Period.of(1, 1, 1);
        System.out.println(period.addTo(LocalDate.of(2000, 2, 22)));
        Instant instant  = Instant.EPOCH;
         }

}
