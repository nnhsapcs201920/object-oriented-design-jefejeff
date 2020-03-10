import java.util.ArrayList;

/**
 * This class uses the factory design pattern to provide a list of
 *      objects that implement the Brain interface
 *
 * @author gcschmit
 * @version 24 January 2020
 */
public class BrainFactory
{
    /**
     * Create a list of references to objects whose classes implement the Brain
     *      interface
     *
     * @return a list of references to objects whose classes implement the Brain
     *      interface
     */
    public static ArrayList<Brain> createBrains()
    {
        //creating ArrayList of type <Brain>        
        ArrayList<Brain> theLads = new ArrayList<Brain>();

        //creating the Brains
        Brain echen = new SimpleBrain();
        Brain ewang = new SmallBrain();

        //adding the Brains to the ArrayList
        theLads.add(echen);
        theLads.add(ewang);

        return theLads;
    }
}
