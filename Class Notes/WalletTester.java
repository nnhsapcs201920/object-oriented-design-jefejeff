/**
 * A class to test the Wallet class
 *
 * @author jcheng3 & eemilyshih
 * @version 4 February 2020
 */
public class WalletTester
{
    public static void main (String[] args)
    {
        Wallet wally = new Wallet();
        Card atm = new ATMCard("jefe", "19072471", "2318");
        Card id = new DriverLicense("emily", 2003); 

        wally.addCard(atm);
        wally.addCard(id);

        System.out.println(wally.toString());
        System.out.println(wally.getExpiredCardCount());
    }
}