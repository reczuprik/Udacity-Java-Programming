// You are going to add a true/false type question to the question heirachy. Call it
// TrueFalseQuestion
//
// When the quiz is displayed, we want this text to preceed the question.
//     Answer True or False: question here
// We want the "Answer True or False: " to be prepended automatically.
// So if the user sets the text of the question to "Albert Einstein was the inventer of Java."
// the question will be displayed to the user like this
//      Answer True or False: Albert Einstein was the inventer of Java.
//
// Capitalization should not matter when determining if the answer is correct. Also t for true
// and f for false should be accepted.
//
// You will need to override three methods although not everyone will override the
// exact same three methods
//
// You will not need to add instance variables
//
//For the draft, make the changes necessary to prepend the question submitted bu the user with
//    Answer True or False:
//
public class TrueFalseQuestion extends Question
{
   // TODO: for the draft, override the appropriate method(s) to present the question as specified
   // TODO: for the final, override the necessay  method(s) all valid answers as specified
    
    private String text;
    private String answer;
    // TODO: Provide any needed instance variables

    /**
       Constructs a numeric question.
       @param aTolerance the tolerance that is allowed when
       checking the answer. For example, if tolerance is 0.01, then
       the response may be up to 0.01 away from the correct answer.
    */
    public TrueFalseQuestion()
    {
        text = "";
        answer = "";
    }

    public boolean checkAnswer(String response)
    {
        
        String responseFixed="FALSE";
         
        if (response.toUpperCase().equals("TRUE" ) ||response.toUpperCase().equals("T") )
        {
            responseFixed="TRUE";
        }
        else if (response.toUpperCase().equals("FALSE" ) || response.toUpperCase().equals("F")) 
        {
            responseFixed="FALSE";
        }
        else
        {
            return false;
        }

        if (responseFixed.equals(answer))
        {
            return true;
        }

        
        return false;//response.equals(answer);
    }
    public void display()
    {
        System.out.print("Answer True or False: ");
        super.display();
    }
    public void setAnswer(String correctResponse)
    {
        answer = correctResponse.toUpperCase();

    }
}
