import java.util.Scanner;

/**
 * A FillInQuestion is constructed with a strong that contains the answer surrounded by '_'.
 *      For example, "The inventor of Java is _James Gosling_." The question should be dispalyed as: The inventor of Java is _____.
 * @author jcheng3
 * @version 30 January 2020
 */

/*
 * The FillInQuestion class extends (i.e., is a subclass of) the Question class.
 */
public class FillInQuestion extends Question
{
    /*
     * Do not declare instance variables for text and answer! The text and answer intance variables are inherited from the Question class!
     */

    /**
     * Constructs a FillInQuestion object with the specified text that contains the answer
     * 
     * @param   question        the specified question text with the embedded answer
     */
    public FillInQuestion(String question)
    {
        /*
         * Explicitly call the Question class's constructor that takes a string parameter
         *      Calling a superclass's constructor must be the first line of code in the
         *      subclass's constructor.
         *      
         * If we don't explicitly call a superclass's constructor, Java will automatically call the
         *      superclass's default (i.e., no parameters) constructor.
         */
        super(question);        
    }    
}
