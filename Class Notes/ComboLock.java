/**
 * A class that models a combination lock
 *
 * @author jcheng3
 * @version 28 January 2020
 */
public class ComboLock
{
    private int first;
    private int second;
    private int third;
    private int lockNumber = 0;
    private boolean firstCheck = false;
    private boolean secondCheck = false;
    private boolean thirdCheck = false;

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
        for(int i = 0; i <ticks; i++)
        {
            lockNumber--;
            if(lockNumber == 0)
            {
                lockNumber = 40;
            }
        }
        if(lockNumber == first)
        {
            firstCheck = true;
        }
        else if(lockNumber == third && firstCheck)
        {
            thirdCheck = true;
        }
    }

    /**
     * A method to turn the lock counterclockwise
     */
    public void turnCounterClockwise(int ticks)
    {
        for(int i = 0; i <ticks; i++)
        {
            lockNumber++;
            if(lockNumber == 40)
            {
                lockNumber = 0;
            }
        }
        if(lockNumber == second)
        {
            secondCheck = true;
        }
    }
}
