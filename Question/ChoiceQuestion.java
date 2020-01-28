import java.util.ArrayList;

/**
A question with multiple choices.
 */
public class ChoiceQuestion extends Question
{
    private ArrayList<String> choices;

    /**
    Constructs a choice question with no choices.
     */
    public ChoiceQuestion()
    {
        this( "" );
    }

    /**
    Constructs a choice question with the specified question.

    @param question the text of this question
     */
    public ChoiceQuestion( String question ) 
    {
        super( question );
        this.choices = new ArrayList<String>();
    }

    /**
    Adds an answer choice to this question.
    @param choice the choice to add
    @param correct true if this is the correct choice, false otherwise
     */
    public void addChoice(String choice, boolean correct)
    {
        this.choices.add(choice);
        if (correct) 
        {
            // Convert choices.size() to string
            String choiceString = "" + this.choices.size();
            this.setAnswer(choiceString);
        }
    }

    public String toString()
    {
        // Display the question text
        String str = super.toString();
        // Display the answer choices
        for (int i = 0; i < this.choices.size(); i++)
        {
            int choiceNumber = i + 1;
            str += choiceNumber + ": " + this.choices.get(i);
        }

        return str;
   }
}

