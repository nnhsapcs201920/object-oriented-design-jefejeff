/**
 * A subclass of Card that mimics an ATM card
 *
 * @author jcheng3 & eemilyshih
 * @version 4 February 2020
 */
public class ATMCard extends Card
{

    private String card;
    private String pin;

    public ATMCard(String n, String cardNumber, String pinNumber)
    {
        super(n);
        card = cardNumber;
        pin = pinNumber;
    }

    @Override
    public String toString()
    {
        String str = super.toString();
        str += " Card Number: " + card + ". Pin Number: " + pin + ".";
        return str;
    }
}