import java.util.Random;
import java.util.Scanner;

/**
A test for the ComboLock class.
 */
public class ComboLockTest
{
    public static void main(String[] args)
    {
        int secret1 = 30;
        int secret2 = 39;
        int secret3 = 35;

        ComboLock lock = new ComboLock(secret1, secret2, secret3);
        Scanner in = new Scanner(System.in);
        boolean opened = false;
        boolean turningClockwise = true;
        lock.reset();
        while(!opened)
        {
            System.out.println("What direction would you like to turn the lock? (cw or ccw): ");
            String direction = in.next();
            turningClockwise = direction.equals("cw");

            System.out.println("Enter number of ticks to turn " + (turningClockwise ? "clockwise" : "counterclockwise") + " Enter a negative number to quit.");
            int ticks = in.nextInt();
            if(ticks < 0)
            {
                return;
            }

            if(turningClockwise)
            {
                lock.turnClockwise(ticks);
            }
            else
            {
                lock.turnCounterClockwise(ticks);
            }

            opened = lock.open();
        }
        System.out.println("You opened the lock!");
    }    
}
