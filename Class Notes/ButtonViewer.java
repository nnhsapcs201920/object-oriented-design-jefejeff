import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class demonstrates how to create and register an action listener.
 *
 * @author jcheng3
 * @version 11 February 2020
 */
public class ButtonViewer
{
    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 100;

    private JFrame frame;
    private JPanel panel;
    private JButton buttonA;
    private JButton buttonB;

    private JLabel label;

    private int clickCountA;
    private int clickCountB;

    /**
     * Constructor for objects of class ButtonViewer
     */
    public ButtonViewer()
    {
        this.clickCountA = 0;
        this.clickCountB = 0;

        //1. define and setup the UI components
        this.frame = new JFrame();
        this.panel = new JPanel();

        this.buttonA = new JButton("Click Me!");
        this.panel.add(this.buttonA);
        this.buttonB = new JButton("No, click Me!");
        this.panel.add(this.buttonB);

        this.label = new JLabel("0 Clicks");
        this.panel.add(this.label);

        this.frame.add(this.panel);

        //2. create listener object
        ClickListener listener = new ClickListener();

        //3. register listener object with component that generates events
        this.buttonA.addActionListener(listener);
        this.buttonB.addActionListener(listener);

        this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        ButtonViewer viewer = new ButtonViewer();
    }

    public class ClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == buttonA)
            {
                clickCountA++;
            }
            else if(event.getSource() == buttonB)
            {
                clickCountB++;
            }
            label.setText("A was clicked " + clickCountA + " times and B was clicked " + clickCountB + " times!");
        }
    }
}