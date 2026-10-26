/*
 * Activity 3.1.3
 */
public class CatCollection
{
  public static void main(String[] args)
  {
    Cat[] cats = {new Cat("Fluffy"), new Cat("Freckles"),new Cat("Boots")};
    
    for (Cat c : cats)
    {
      if (c.getName().equals("Boots"))
        c.setName("Kitty"); 
    }
    
    // confirm array is unchanged
    for (Cat c : cats)
    {
      System.out.println(c);
    }
    for (Cat c : cats)
    {
      System.out.println(c.getAge());
      c.setAge((int)(c.getAge()+2));
      System.out.println(c.getAge());
    }
    

  }
}