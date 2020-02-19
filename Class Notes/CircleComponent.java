import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CircleComponent extends JComponent
{
    private static final int MAX_POINTS = 3;
    private int clickCount = 0;
    private Point2D.Double point1 = new Point2D.Double();
    private Ellipse2D.Double circle = new Ellipse2D.Double();
    private Point2D.Double point2 = new Point2D.Double();
    private Line2D.Double line1 = new Line2D.Double();
    private Point2D.Double point3 = new Point2D.Double();
    private Line2D.Double line2 = new Line2D.Double();
    private Line2D.Double line3 = new Line2D.Double();
    private int mouseX;
    private int mouseY;

    public CircleComponent()
    {
        CircleListener listener = new CircleListener();
        this.addMouseListener(listener);
    }

    @Override
    public void paintComponent(Graphics g)
    {  
        super.paintComponent( g );
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(circle);
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3);
    }

    public class CircleListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            mouseX = e.getX();
            mouseY = e.getY();
            clickCount++;
            if(clickCount == 1)
            {
                circle = new Ellipse2D.Double(mouseX - 5, mouseY - 5, 10, 10);
                point1 = new Point2D.Double(mouseX, mouseY);
            }
            else if (clickCount == 2)
            {
                point2 = new Point2D.Double(mouseX, mouseY);
                circle = new Ellipse2D.Double();
                line1 = new Line2D.Double(point1.getX(), point1.getY(), point2.getX(), point2.getY());
            }
            else if (clickCount == 3)
            {
                point3 = new Point2D.Double(mouseX, mouseY);
                line2 = new Line2D.Double(point1.getX(), point1.getY(), point3.getX(), point3.getY());
                line3 = new Line2D.Double(point2.getX(), point2.getY(), point3.getX(), point3.getY());
            }
            else
            {
                point1 = new Point2D.Double();
                circle = new Ellipse2D.Double();
                point2 = new Point2D.Double();
                line1 = new Line2D.Double();
                point3 = new Point2D.Double();
                line2 = new Line2D.Double();
                line3 = new Line2D.Double();
                clickCount = 0;
            }
            repaint();
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