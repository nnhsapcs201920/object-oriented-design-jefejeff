import java.awt.Rectangle;

/**
 * A subclass of Rectangle, with methods to calculate area and perimeter
 *
 * @author jcheng3
 * @version 5 February 2020
 */
public class BetterRectangle extends Rectangle
{
    public BetterRectangle(int width, int height)
    {
        super(width, height);
    }

    public int getPerimeter()
    {
        int perimeter = 0;
        perimeter += 2 * (super.getWidth());
        perimeter += 2 * (super.getHeight());
        return perimeter;
    }

    public int getArea()
    {
        int area = 0;
        area = (int) super.getWidth() * (int) super.getHeight();
        return area;
    }
}
