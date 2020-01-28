import javax.swing.JFrame;

public class TriangleFrame extends JFrame
{
    private TriangleComponent component;

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    public TriangleFrame()
    {
        this.component = new TriangleComponent();
        
        this.add(component);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Triangle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    

    public static void main(String [] args)
    {
        JFrame frame = new TriangleFrame();
    }
}