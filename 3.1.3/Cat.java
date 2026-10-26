/*
 * Activity 3.1.3
 *
 * A Cat class
 */
public class Cat
{
  private String name;
  private double age;
  
  public Cat()
  {
    name = "";
    age = 0;
  }
  
  public Cat(String n)
  {
    name = n;
    age = 0;
  }
  
  public Cat(String n, double a)
  {
    name = n;
    age = a;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String n)
  {
    name = n;
  }
 
  public double getAge()
  {
    return age;
  }
  
  public void setAge(int a)
  {
    age = a;
  }
  
  public void eat(String food)
  {
    System.out.println("I eat " + food + ".");
  }

  public void play(String toy)
  {
      System.out.println("Oh boy! I get to play with my " + toy + "!");
  }

  public String toString()
  {
    return name;
  }
}