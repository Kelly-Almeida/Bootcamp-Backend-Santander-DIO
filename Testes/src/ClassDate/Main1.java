package ClassDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main1 {
    public static void main(String[] args){
        //Obsolenta
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
        System.out.println(formatter.format(calendar.getTime()));

        Date date = calendar.getTime();
        System.out.println(date);
        //calendar.setTime(date);


        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)); //Inicia no mẽs 0 (janeiro)
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        var newCalendar = Calendar.getInstance();
        newCalendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) +1);
        System.out.println(calendar.after(newCalendar));

        var stringDate = formatter.format(calendar.getTime());
        stringDate = stringDate.replace("19", "21");
        try {
            var newCallendar = formatter.parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
