import java.util.Collections;
import java.util.ArrayList;


/**
 * Test class for Coin class
 *
 * @author gcschmit
 * @version 19 June 2019
 */
public class CoinTest
{
    /**
     * Tests the Coin class' implementation of the Comparable interface.
     */
    public static void testComparable()
    {
        Coin quarter = new Coin(0.25, "quarter");
        Coin dime = new Coin(0.10, "dime");
        Coin nickel = new Coin(0.05, "nickel");

        ArrayList<Coin> list = new ArrayList<Coin>();
        list.add(quarter);
        list.add(dime);
        list.add(nickel);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
