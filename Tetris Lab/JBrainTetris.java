import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;
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

    //checking if the Brain is on/off
    private boolean power;

    //the best move
    private Move bestMove;

    /**
     * Constructor for objects of class JBrainTetris
     * 
     * @param width     the width of the window
     * @param height    the height of the window
     */
    public JBrainTetris(int width, int height)
    {
        //calls super constructor
        super(width, height);
    }

    @Override
    /**
     * Creates the panel of UI controls, with additional elements
     */
    public java.awt.Container createControlPanel()
    {
        //invoking super
        java.awt.Container panel = super.createControlPanel();

        //calling createBrains and initializing the ArrayList
        BrainFactory panthers = new BrainFactory();
        ArrayList<Brain> theLads = panthers.createBrains();

        //creating an Array and converting the ArrayList into an Array
        Brain [] brains = new Brain[theLads.size()];
        for(int i = 0; i < brains.length; i++)
        {
            brains[i] = theLads.get(i);
        }

        //creating JComboBox and initializing the Brain to the first item in the JComboBox
        JComboBox boxy = new JComboBox(brains);
        myOneBrainCell = brains[0];

        //creating ActionListener (copied from JTetris)
        boxy.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    //changing selected Brain
                    myOneBrainCell = (Brain) boxy.getSelectedItem();
                }
            });

        //adding JComboBox to Control Panel
        panel.add(boxy);

        //creating JButton
        JButton button = new JButton();

        //checking for testMode to initialize starting text and if the Brain is enabled
        if(!testMode)
        {
            button.setText("Enable brain");
            power = false;
        }
        else if (testMode)
        {
            button.setText("Disable brain");
            power = true;
        }

        //creating ActionListener (copied from JTetris)
        button.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    //toggling Brain on and off, as well as switching text labels
                    if(!power)
                    {
                        power = true;
                        button.setText("Disable brain");
                    }
                    else if (power)
                    {
                        power = false;
                        button.setText("Enable brain");
                    }
                }
            });

        //adding button to panel
        panel.add(button);

        return panel;
    }

    /**
     * Selects the next piece to use using the random generator set in startGame(), as well
     *      as calculating the bestMove and initializing it
     * 
     * @return      the next Piece
     */
    @Override
    public Piece pickNextPiece()
    {
        //invoking super
        Piece p = super.pickNextPiece();

        //commiting board
        this.board.commit();

        //calculating bestMove
        bestMove = myOneBrainCell.bestMove(board, p, 20, null);

        return p;
    }

    /**
     * Called to change the position of the current piece. Before this is called, the piece is at some location in the board.
     *      This advances the piece to be at its next location. This override moves the piece a bit first (if the brain is enabled).
     *      The brain may do up to one rotation and one left/right move each time tick() is called.
     *      The piece should drift down to its correct place.
     *      
     *      @param verb     should be DOWN, called by the brain to tick
     */
    @Override
    public void tick(int verb)
    {
        //checking if Brain is enabled
        if(power)
        {
            //moving the piece down
            super.tick(DOWN);

            //if the piece is left of the bestMove, moving the piece to the right
            if(this.currentX < bestMove.x)
            {
                super.tick(RIGHT);
            }

            //if the piece is right of the bestMove, moving the piece to the left
            else if (this.currentX > bestMove.x)
            {
                super.tick(LEFT);
            }

            //if the piece is not in the best direction, rotates the piece
            if(!this.currentPiece.equals(bestMove.piece))
            {
                super.tick(ROTATE);
            }
        }

        //if not, play normally
        else
            super.tick(verb);
    }

}
