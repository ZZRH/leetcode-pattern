package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConvert {
    public static void main(String[] args) {
        Date date = new Date(1606292076172L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf.format(date));
    }
}
