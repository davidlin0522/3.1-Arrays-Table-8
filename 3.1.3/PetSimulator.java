/*
 * Activity 3.1.3
 */
public class PetSimulator
{
  public static void main(String[] args)
  {
    // create an array that can hold up to 10 pets (does not require looping)
    Pet[] pets = new Pet[10];
    // adopt (create and name) four pets, two cats, two dogs (does not require looping) CAT: 1, DOG: 2
    Pet cat1 = new Pet("m1",1);
    Pet cat2 = new Pet("m2",1);
    Pet dog1 = new Pet("b1",2);
    Pet dog2 = new Pet("b2",2);
    // first things first, feed your pets
    pets[0] = cat1;
    pets[1] = cat2;
    pets[2] = dog1;
    pets[3] = dog2;
    for (Pet p: pets) {
      if (p != null) {
        p.feed();
      }
    }
    // next, make yourself the owner of all of your new pets
    for (Pet p: pets) {
      if (p != null) {
        p.setOwner("Davi Lin");
      }
    }
    // your dogs make some noise, take them for a walk

    for (Pet p: pets) {
      if (p!= null){
        if (p.getType() == 2) {
        p.walk();
  }}}

    // when you get back, your cats make some noise
    
    for (Pet p: pets) {
      if (p!= null){
        if (p.getType() == 1) {
          p.makeNoise();
  }}}
    // give all of your pets a treat
    for (Pet p: pets) {
      if (p!= null){
        p.feed();
  }}
    // groom your cats
    for (Pet p: pets) {
      if (p!= null){
        if (p.getType() == 1) {
          p.groom();
  }}}
    // grooming is done, play with all pets
    for (Pet p: pets) {
      if (p!= null){
        p.play();
  }}
    // whew, that was tiring, all pets nap and get fed
    for (Pet p: pets) {
      if (p!= null){
        p.feed();
        p.sleep();
  }}

    System.out.println("--- MY PETS ---");
    // show the state of all of your pets
    for (Pet p: pets) {
      if (p!= null){
        System.out.println(p.toString());
  }}

    // You decide to get a couple of pets for your friend (does not require looping)
    Pet cat3 = new Pet("m3",1);
    Pet dog3 = new Pet("b3",2);

    // set the owner of the new pets to your friends name
    cat3.setOwner("Chester");
    dog3.setOwner("Chester");
    pets[4] = cat3;
    pets[5] = dog3;
    System.out.println("--- MY PETS ---");
    // show the state of all of your pets
    for (Pet p: pets) {
      if (p!= null){
        System.out.println(p.toString());
  }}
  }
}