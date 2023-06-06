package localDate;

import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);
        System.out.print(date.getDayOfYear());
        System.out.print(" " + date.getDayOfMonth());*/

/*        int year = scanner.nextInt();
        int day1 = scanner.nextInt();
        int day2 = scanner.nextInt();
        int day3 = scanner.nextInt();
        System.out.println(LocalDate.ofYearDay(year,day1));
        System.out.println(LocalDate.ofYearDay(year,day2));
        System.out.println(LocalDate.ofYearDay(year,day3));*/

/*        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);
        int skip = scanner.nextInt();
        int skip2 = skip;
        System.out.println(date);
        LocalDate date1 = date.plusDays(skip);
        while (date1.getYear() == date.getYear()) {
            System.out.println(date1);
            skip += skip2;
            date1 = date.plusDays(skip);
        }*/
        LocalDate date = LocalDate.ofYearDay(scanner.nextInt(), scanner.nextInt());
        if (date.plusDays(1).getDayOfMonth() == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}