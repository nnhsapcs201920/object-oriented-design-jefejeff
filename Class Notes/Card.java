/**
 * A class to mimic cards of different types
 *
 * @author eemilyshih jcheng3
 * @version 4 February 2020
 */
public class Card
{
    private String name;

    public Card()
    {
        name = "";
    }

    public Card(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }

    public boolean isExpired()
    {
        return false;
    }

    public String toString()
    {
        return "Card holder: " + name + ".";
    }
}