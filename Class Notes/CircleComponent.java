import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Dimension;

public class CircleComponent extends JComponent
{
    public CircleComponent()
    {
        this.setPreferredSize(new Dimension(333, 333));
    }

    @Override
    public void paintComponent(Graphics g)
    {  
        super.paintComponent( g );
        Graphics2D g2 = (Graphics2D) g;
    }
}