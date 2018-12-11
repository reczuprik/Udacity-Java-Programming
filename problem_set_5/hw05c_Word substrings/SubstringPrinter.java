
public class SubstringPrinter
{
   public static void main(String[] args)
   {
      Word word = new Word("rum");
      System.out.println(word.getSubstrings());   
      
      word = new Word("thisisaverylongword");
      System.out.println(word.getSubstrings()); 
   }

}
