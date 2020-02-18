import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TriangleComponent extends JComponent
{
    private static final int MAX_POINTS = 3;
    private int clickCount = 0;
    private Point2D.Double point1;
    private Ellipse2D.Double circle;
    private Point2D.Double point2;
    private Line2D.Double line1;
    private Point2D.Double point3;
    private Line2D.Double line2;
    private Line2D.Double line3;
    private int mouseX;
    private int mouseY;

    public TriangleComponent()
    {
        TriangleListener listener = new TriangleListener();
        this.addMouseListener(listener);
    }

    @Override
    public void paintComponent(Graphics g)
    {  
        super.paintComponent( g );
        Graphics2D g2 = (Graphics2D) g;
    }

    public class TriangleListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            mouseX = e.getX();
            mouseY = e.getY();
            System.out.println("clicked!");
            clickCount++;
            if(clickCount == 1)
            {
                circle = new Ellipse2D.Double(mouseX - 5, mouseY - 5, 10, 10);
                point1 = new Point2D.Double(mouseX, mouseY);
            }
            else if (clickCount == 2)
            {
                point2 = new Point2D.Double(mouseX, mouseY);
                circle = null;
                line1 = new Line2D.Double(point1.getX(), point1.getY(), point2.getX(), point2.getY());
            }
            else if (clickCount == 3)
            {
                point3 = new Point2D.Double(mouseX, mouseY);
                line2 = new Line2D.Double(point1.getX(), point1.getY(), point3.getX(), point3.getY());
                line2 = new Line2D.Double(point1.getX(), point1.getY(), point3.getX(), point3.getY());
            }
            else
            {
                point1 = null;
                point2 = null;
                point3 = null;
                line1 = null;
                line2 = null;
                line3 = null;
                clickCount = 0;
            }

        }

        @Override
        public void mousePressed(MouseEvent e)
        {

        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
        }
    }

}