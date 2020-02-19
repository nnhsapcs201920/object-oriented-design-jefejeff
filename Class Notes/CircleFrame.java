import javax.swing.JFrame;

/**
 * A frame for our circle GUI
 *
 * @author jcheng3
 * @version 19 February 2020
 */
public class CircleFrame extends JFrame
{
    private CircleComponent component;

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    public CircleFrame()
    {
        this.component = new CircleComponent();

        this.add(component);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Triangle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String [] args)
    {
        JFrame frame = new CircleFrame();
    }
}
