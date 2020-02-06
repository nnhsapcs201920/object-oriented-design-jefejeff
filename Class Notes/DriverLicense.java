import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * A subclass of Card that mimics a driver's license
 *
 * @author jcheng3
 * @version 4 February 2020
 */
public class DriverLicense extends Card
{

    private int year;
    public DriverLicense(String n, int expirationYear)
    {
        super(n);
        year = expirationYear;
    }

    @Override
    public boolean isExpired()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        int thisYear = calendar.get(Calendar.YEAR);
        boolean expired = false;
        if(thisYear > year)
        {
            expired = true;
        }
        return expired;
    }

    @Override
    public String toString()
    {
        String str = super.toString();
        str += " Year: " + year + ".";
        return str;
    }
}