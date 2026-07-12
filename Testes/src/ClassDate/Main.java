package ClassDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args){

        //DEPRESSIADA
        var date = new Date();
        System.out.println(date);

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss"); //Padrão pm/am, em caso de dos h's serem maiúsculos o padrão será 24h
        System.out.println(formatter.format(date));

        Date date1 = new Date(System.currentTimeMillis() - 639600089099L);
        System.out.println(date1);

        Date date2 = new Date();
        date2.setYear(100); //Começa do 1900
        System.out.println(date2);
        date2.setHours(20);
        System.out.println(date2);

        var milliseconds = System.currentTimeMillis();
        var date3 = new Date(milliseconds);

        System.out.println(date3.equals(milliseconds)); //Comparando se são iguais


    }
}
