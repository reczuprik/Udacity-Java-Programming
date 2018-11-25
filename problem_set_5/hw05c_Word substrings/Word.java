//Create a class Word. Word has a constructor that takes a string argument
//and one method getSubstrings which returns a String containing
//all substring of word, sorted by length.

//For example, if the user provides the input "rum", the method returns a
//string that will print like this
//r
//u
//m
//ru
//um
//rum


//You can concatenate the substrings in a String, separating them with a newline
//("\n"). Then return the string

// Need help starting this question? In the lesson titled 
// "Starting points: Problem Set Questions", go to the
// problem titled "Problem Set 5 - Question 3" for some tips on 
// how to begin.

public class Word
{
    //TODO write the constructor and define the instance variable
    private String word;
    
    public Word(String inputword)
    {
        
        this.word = inputword;
    }
    /**
     * Gets all the substrings of this Word.
     * @return all substrings of this Word separated by newline
     */
    public String getSubstrings()
    {
        final String newline ="\n";
        String returnString = "";
        int firstcharacter=0;
        int lastcharacter=0;
        int j=0;
        for(int lengthOfTheWord=1;lengthOfTheWord<=word.length();lengthOfTheWord++) 
        {
            for (int i=0;i<=word.length()-lengthOfTheWord;i++)
            {
                lastcharacter = i + lengthOfTheWord;
                
                returnString=returnString + word.substring(i, lastcharacter)+newline;
//                System.out.println(i+"-"+returnString);
            }
            
        }
        
        return returnString;
    }
}

