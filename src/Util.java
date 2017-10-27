import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lyc on 2017/10/27.
 */
public class Util {
    public static Integer countdays(String getDay, String useDay) {

        getDay = convert(getDay);
        useDay = convert(useDay);

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(getDay);
            Date date2 = sdf.parse(useDay);

            return getDistanceOfTwoDate(date1, date2).intValue();

        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }


        return 0;
    }

    private static String convert(String getDay) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < getDay.length() ; i++) {
            sb.append(getDay.charAt(i));
            if(i == 3 || i==5){
                sb.append('-');
            }
        }

        return sb.toString();
    }

    public static Double getDistanceOfTwoDate(Date before, Date after) {
        if(before != null && after != null ){
            long beforeTime = before.getTime();
            long afterTime = after.getTime();
            return Double.valueOf((afterTime - beforeTime) / (1000 * 60 * 60 * 24));
        }
        return Double.valueOf(0) ;
    }


}
