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

    public TriangleComponent()
    {
        
    }

    @Override
    public void paintComponent(Graphics g)
    {  
        super.paintComponent( g );
        Graphics2D g2 = (Graphics2D) g;

    }

}