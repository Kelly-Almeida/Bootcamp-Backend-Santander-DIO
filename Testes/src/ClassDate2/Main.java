package ClassDate2;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(formatter.format(localDate));

        var strDate = "22/12/2015";
        System.out.println(LocalDate.parse(strDate, formatter)); //Em caso de não haver o formatter, dará erro devido ao formato padrão tratado pela Classe ex: 12-01-2004

        System.out.println(localDate.plus(50, ChronoUnit.DAYS));
        System.out.println(localDate.plusMonths(3));
        System.out.println(localDate.minus(60, ChronoUnit.DAYS));

        System.out.println(localDate.getEra());

        //localDate.isEqual(); //Comara dadas de diferente formatos
        //localDate.equals();//Verifica a instância e se eles são iguais

        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println(formatter1.format(localTime));

        System.out.println(localTime.toSecondOfDay());
        System.out.println(localTime.withHour(1));

        /*DateTimeFormatter formatter2 = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(formatter2.format(localDateTime));*/

        LocalDateTime localDateTime = localDate.atTime(localTime);

        /*
        var date = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(-3)));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(date);
        System.out.println(calendar);*/

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        ZoneId zoneId = calendar.getTimeZone().toZoneId();
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(calendar.toInstant(), zoneId);
        System.out.println(localDateTime1);

        System.out.println(Duration.between(localDateTime, localDateTime1.plus(30, ChronoUnit.DAYS)).toMillis());
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        System.out.println(offsetDateTime);

        offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);
        System.out.println(offsetDateTime);

        //offsetDateTime.isBefore();
        //offsetDateTime.isAfter();
        //offsetDateTime.isEqual();//Comparar data e hora de diferentes zonas
        //offsetDateTime.equals();//Igualdade de obejtos
        var date1 = Date.from(offsetDateTime.toInstant());
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
    }
}
