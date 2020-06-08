/**
 * Code for HW8
   A sentence that can be reversed.
   @Kenan Dolic
*/
public class Sentence
{
   private String text;

   /**
      Creates a Sentence object.
      @param aText the text of this sentence.
   */
   public Sentence(String aText)
   {
      text = aText;
   }
   
   /**
      Reverses this sentence.
   */
   public void reverse()
   {
	   text = reverse(text);
   }
   
   private String reverse(String string1)
   {
	   if(string1.length() == 0)
	   {
		   return string1;
	   }
	   else
	   {
		   return reverse(string1.substring(1)) + string1.charAt(0);
	   }
   }
   
   /**
      Gets the sentence text.
      @return the sentence text
   */
   public String getText()
   {
      return text;   
   }
}
