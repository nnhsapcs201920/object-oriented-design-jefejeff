import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A frame for our circle GUI
 *
 * @author jcheng3
 * @version 19 February 2020
 */
public class CircleFrame extends JFrame
{
    private JPanel panel;
    private CircleComponent component;
    private JButton button;

    private int x;
    private int y;
    private int radius;

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    public CircleFrame()
    {
        this.panel = new JPanel();
        this.component = new CircleComponent();
        this.button = new JButton("Draw circle.");

        component.add(button);
        panel.add(component);
        this.add(panel);

        CircleListener listener = new CircleListener();
        this.button.addActionListener(listener);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Circle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String [] args)
    {
        JFrame frame = new CircleFrame();
    }
    public class CircleListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            x = Integer.parseInt(JOptionPane.showInputDialog(component, "Enter an x value for the center of your circle."));
            y = Integer.parseInt(JOptionPane.showInputDialog(component, "Enter an y value for the center of your circle."));
            radius = Integer.parseInt(JOptionPane.showInputDialog(component, "Enter an a radius for your circle."));

        }
    }
}
