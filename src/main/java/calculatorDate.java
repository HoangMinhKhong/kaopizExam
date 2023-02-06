import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class calculatorDate {
    static SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
    static Integer startDateInt = 20170220;
    static Integer closeDateInt = 20211224;

    public static void main(String[] args) throws ParseException {
        sumDate();
        addDate(startDateInt, 1);
    }

    static void sumDate() throws ParseException {
        Date startDate = originalFormat.parse(startDateInt.toString());
        Date closeDate = originalFormat.parse(closeDateInt.toString());
        long timeDiff = Math.abs(startDate.getTime() - closeDate.getTime());
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        System.out.println("Tổng số ngày từ start date tới close date là: " + daysDiff);
    }

    static void addDate(Integer startDateInt, int month) throws ParseException {
        Date startDate = originalFormat.parse(startDateInt.toString());
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.MONTH, 1);
        Date currentDatePlusOne = cal.getTime();
        System.out.println("Thêm một tháng vào start date thì được close date là: " + originalFormat.format(currentDatePlusOne));
    }
}
