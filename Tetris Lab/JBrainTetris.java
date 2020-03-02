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

        //creating JButton WORK IN PROGRESS
        if(!testMode)
        {
            JButton button = new JButton("Enable Brain");
            button.addActionListener( new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        myOneBrainCell = (Brain) boxy.getSelectedItem();
                    }
                });
        }

        if(testMode)
        {
            JButton button = new JButton("Disable Brain");
            button.addActionListener( new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        myOneBrainCell = (Brain) boxy.getSelectedItem();
                    }
                });
        }
        return panel;
    }
}
