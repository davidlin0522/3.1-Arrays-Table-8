/*
 * Activity 3.1.3
 */
public class NonChangingGoals
{
  public static void main(String[] args) 
  {
    int[] goals = {1,2,0,3,2,4,2,1,0,2,0,1,3,2};
    
    // start a new season!
    for (int g : goals)
    {
      g = 0;
    }
     
    for (int g : goals)
    {
      System.out.print(g + " " );
    }
  }
}