/**
 * A class that models a combination lock
 *
 * @author jcheng3 & eemilyshih
 * @version 28 January 2020
 */
public class ComboLock
{
    private int first;
    private int second;
    private int third;
    private int lockNumber = 0;
    private boolean firstCheck;
    private boolean secondCheck;
    private boolean thirdCheck;

    /**
     * Constructor for objects of class ComboLock
     */
    public ComboLock(int secret1, int secret2, int secret3)
    {
        first = secret1;
        second = secret2;
        third = secret3;
    }

    /**
     * A method to reset the lock to 0
     */
    public void reset()
    {
        lockNumber = 0;
    }

    /**
     * A method to turn the lock clockwise
     */
    public void turnClockwise(int ticks)
    {
        /* for(int i = 0; i < ticks; i++)
        {
        if(lockNumber == 0)
        {
        lockNumber = 40;
        }
        lockNumber--;
        }
        if(lockNumber == first)
        {
        firstCheck = true;
        }
        else if(lockNumber == third && firstCheck)
        {
        thirdCheck = true;
        } */
        lockNumber -= ticks;
        if(lockNumber < 0)
        {
            lockNumber = 40 + lockNumber;
        }
        if(lockNumber == first)
        {
            firstCheck = true;
        }
        else if(lockNumber == third && firstCheck == true)
        {
            thirdCheck = true;
        }
    }

    /**
     * A method to turn the lock counterclockwise
     */
    public void turnCounterClockwise(int ticks)
    {
        /* for(int i = 0; i < ticks; i++)
        {
        if(lockNumber == 40)
        {
        lockNumber = 0;
        }
        lockNumber++;
        }
        if(lockNumber == second)
        {
        secondCheck = true;
        } */
        lockNumber =+ ticks;
        if(lockNumber > 39)
        {
            lockNumber = lockNumber - 40;
        }
        if(lockNumber == second)
        {
            secondCheck = true;
        } 
    }

    /**
     * A method to open the lock, if all conditions are met
     */
    public boolean open()
    {
        boolean opened;
        if(firstCheck && secondCheck && thirdCheck)
        {
            opened = true;
        }
        else
        {
            opened = false;
        }
        return opened;
    }
}
