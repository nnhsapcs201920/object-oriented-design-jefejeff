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
        myOneBrainCell = brains[0];

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

    @Override
    public void tick(int verb)
    {
        super.tick(DOWN);
        if(this.currentX < bestMove.x)
        {
            super.tick(RIGHT);
        }
        else if (this.currentX > bestMove.x)
        {
            super.tick(LEFT);
        }
        if(!this.currentPiece.equals(bestMove.piece))
        {
            super.tick(ROTATE);
        }
    }

}
