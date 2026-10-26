/*
 * Activity 3.1.3
 */
 public class NewEnglandCapitals
{
  public static void main(String[] args)
  {
    String[] newEnglandCapitals = {"Augusta, Concord",
                           "Montpelier", "Boston",
                           "Hartford", "Providence"};

    System.out.println("The New England Capitals:");

    for(String capital : newEnglandCapitals)
    {
      capital = capital.substring(0,0);
    } 
    
    for(String capital : newEnglandCapitals)
    {
      System.out.println(capital);
    } 
    
  }
}