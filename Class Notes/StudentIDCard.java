/**
 * A subclass of Card to mimic a student ID card
 *
 * @author jcheng3 & eemilyshih
 * @version 4 February 2020
 */
public class StudentIDCard extends Card
{
    private String idNumber;

    public StudentIDCard(String n, String id)
    {
        super(n);
        idNumber = id;
    }

    @Override
    public String toString()
    {
        String str = super.toString();
        str += " ID Number: " + idNumber + ".";
        return str;
    }
}