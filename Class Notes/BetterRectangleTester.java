import java.awt.Rectangle;

/**
 * A class to test the BetterRectangle class
 *
 * @author jcheng3
 * @version 5 February 2020
 */
public class BetterRectangleTester
{
    public static void main (String[] args)
    {
        BetterRectangle betrect = new BetterRectangle(2, 2);
        System.out.println("Area: " + betrect.getArea() + ". Perimeter: " + betrect.getPerimeter() + ".");
    }
}
