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

    //Brain on/off
    private boolean power;

    //bestMove
    private Move bestMove;

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
        //invoking super
        java.awt.Container panel = super.createControlPanel();

        //calling createBrains and initializing the ArrayList
        BrainFactory panthers = new BrainFactory();
        ArrayList<Brain> theLads = panthers.createBrains();

        //creating JComboBox
        Brain [] brains = new Brain[theLads.size()];
        for(int i = 0; i < brains.length; i++)
        {
            brains[i] = theLads.get(i);
        }
        JComboBox boxy = new JComboBox(brains);

        //creating ActionListener
        boxy.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    myOneBrainCell = (Brain) boxy.getSelectedItem();
                }
            });

        //adding JComboBox to Control Panel
        panel.add(boxy);

        //creating JButton

        JButton button = new JButton();
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

        //adding listener
        button.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
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
     * Selects the next piece to use using the random generator set in startGame().
     */
    @Override
    public Piece pickNextPiece()
    {
        //invoking super
        Piece p = super.pickNextPiece();

        //commit board
        this.board.commit();

        //calculating bestMove
        bestMove = myOneBrainCell.bestMove(board, p, 20, null);

        return p;
    }
    
    /**
     * Called to change the position of the current piece.
     *  Each key press call this once with the verbs LEFT RIGHT ROTATE DROP for
     *      the user moves, and the timer calls it with the verb DOWN to move
     *      the piece down one square.
     *      
     *  Before this is called, the piece is at some location in the board.
     *  This advances the piece to be at its next location.    
     *  
    */
   @Override
    public void tick(int verb)
    {
        if (!this.gameOn)
        {
            return;
        }
        
        if (this.currentPiece != null)
        {
            this.board.undo();   // remove the piece from its old position
        }
        
        // Sets the newXXX attributes
        this.computeNewPosition(verb);
        
        // try out the new position (rolls back if it doesn't work)
        int status = this.setCurrent(this.newPiece, this.newX, this.newY);
        
        // if row clearing is going to happen, draw the whole board so the green
        //      row shows up
        if (status ==  Board.PLACE_ROW_FILLED)
        {
            this.repaint();
        }
        

        boolean failed = (status >= Board.PLACE_OUT_BOUNDS);
        
        // if it didn't work, put it back the way it was
        if (failed)
        {
            if (this.currentPiece != null)
            {
                this.board.place(this.currentPiece, this.currentX, this.currentY);
            }
        }
        
        /*
         * How to detect when a piece has landed:
         *      if this move hits something on its DOWN verb, and the previous
         *          verb was also DOWN (i.e. the player was not still moving it),
         *          then the previous position must be the correct "landed"
         *          position, so we're done with the falling of this piece.
        */
        if (failed && verb==DOWN && !this.moved)   // it's landed
        {
            if (this.board.clearRows())
            {
                this.repaint();  // repaint to show the result of the row clearing
            }
            
            // if the board is too tall, we've lost
            if (this.board.getMaxHeight() > this.board.getHeight() - TOP_SPACE)
            {
                this.stopGame();
            }
            // Otherwise add a new piece and keep playing
            else
            {
                this.addNewPiece();
            }
        }
        
        // Note if the player made a successful non-DOWN move --
        //      used to detect if the piece has landed on the next tick()
        this.moved = (!failed && verb!=DOWN);
    }
    
}
