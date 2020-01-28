/**
   A question with a text and an answer.
*/
public class Question
{
   private String text;
   private String answer;

   /**
      Constructs a question with empty question and answer.
   */
   public Question() 
   {
   }
   
   /**
      Constructs a question with the specified question.
      
      @param question the text of this question
   */
   public Question( String question ) 
   {
      this.setText(question);
   }

   /**
      Sets the question text.
      @param questionText the text of this question
   */
   public void setText(String questionText)   
   {
      this.text = questionText;
   }

   /**
      Sets the answer for this question.
      @param correctResponse the answer
   */
   public void setAnswer(String correctResponse)
   {
      this.answer = correctResponse;
   }

   /**
      Checks a given response for correctness.
      @param response the response to check
      @return true if the response was correct, false otherwise
   */
   public boolean checkAnswer(String response)
   {
      return response.equals(this.answer);
   }

   /**
      Displays this question.
   */
   public String toString()
   {
      return this.text;
   }
}
