package ua.com.alevel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateApiMain {

    public static void main(String[] args) {
        System.out.println("DateApiMain.main");
        finish();
    }

    private static void finish() {
        ZoneOffset zoneOffsetCapital = ZoneOffset.of("+03:00");
        ZoneOffset zoneOffsetCurrent = ZoneOffset.of("+07:00");
        LocalDateTime localDateTime = LocalDateTime.of(2021, 6, 22, 1, 0, 0);

        OffsetDateTime offsetDateTimeCapital = OffsetDateTime.of(localDateTime, zoneOffsetCapital);
        OffsetDateTime offsetDateTimeCurrent = OffsetDateTime.of(localDateTime, zoneOffsetCurrent);

        System.out.println("offsetDateTimeCapital = " + offsetDateTimeCapital);
        System.out.println("offsetDateTimeCurrent = " + offsetDateTimeCurrent);
    }

    private static void dateTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        boolean after = localDate.isAfter(LocalDate.now());
        System.out.println(after);

        LocalTime localTime = LocalTime.now();
        localTime = LocalTime.of(20, 0 ,0);
        System.out.println("localTime = " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime = " + offsetDateTime);
        ZoneOffset offset = offsetDateTime.getOffset();
        System.out.println("offset = " + offset.getTotalSeconds());

        ZoneOffset zoneOffset = ZoneOffset.of("+01:00");
        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(LocalDateTime.now(), zoneOffset);
        System.out.println("offsetDateTime1 = " + offsetDateTime1);
    }

    private static void calendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar);
        System.out.println("calendar = " + calendar.getTime());
        calendar.add(Calendar.MONTH, 2);
        System.out.println("calendar = " + calendar.getTime());

        calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MARCH, 29, 2, 59, 59);
        System.out.println("calendar = " + calendar.getTime());

        Calendar current = Calendar.getInstance();
        current.setTimeZone(TimeZone.getTimeZone("Europe/Zaporozhye"));
        System.out.println(current.after(calendar));
        System.out.println(current.getTimeZone());
        System.out.println(current.getTime());
    }

    private static void start() {
        // 21.06.21 - 23.00.00
        // 22.06.21 - 01.00.00
        // 1 January 1970
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());

//        Date endDate = new Date(Long.MAX_VALUE);
//        System.out.println(endDate);

        Date current = new Date();

        DateFormat format = SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.LONG, SimpleDateFormat.LONG);
        String dateFormat = format.format(current);

        System.out.println("dateFormat = " + dateFormat);

        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        dateFormat = format.format(current);

        System.out.println("dateFormat = " + dateFormat);
    }
}
