/**
 * A subclass of JTetris, an AI brain to play the Tetris game
 *
 * @author jcheng3
 * @version 27 February 2020
 */
public class JBrainTetris extends JTetris
{
    //currently selected Brain
    private Brain myOneBrainCell;

    /**
     * Constructor for objects of class JBrainTetris
     */
    public JBrainTetris(int width, int height)
    {
        super(width, height);
    }
    
    @Override
    /**
     * Creates the panel of UI controls.
     */
    public java.awt.Container createControlPanel()
    {
        super();
        
    }
}
