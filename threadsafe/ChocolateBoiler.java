package com.j2.singleton.chocolate.threadsafe;

public class ChocolateBoiler {
  private boolean empty;
  private boolean boiled;
  private static ChocolateBoiler uniqueInstance;
  private static int numCalled = 0;
 
  private ChocolateBoiler() {
    empty = true;
    boiled = false;
  }
  
  //using synchronized to threadsafe
  public static synchronized ChocolateBoiler getInstance() {
    if(uniqueInstance == null) {
      System.out.println("Creating unique instance of Chocolate Boiler.");
      uniqueInstance = new ChocolateBoiler();
    }
    System.out.println("Returning instance of Chocolate Boiler");
    System.out.println("numCalled : " + numCalled++);
    return uniqueInstance;
  }
  
 // fill the boiler with a milk/chocolate mixture
  public void fill() {
    if (isEmpty()) {
      empty = false;
      boiled = false;
    }
  }
 
  //bring the contents to a boil
  public void boil() {
    if(!isEmpty() && !isBoiled()){
      boiled = true;
    }
  }
  
  //drain the boiled milk and chocolate      
  public void drain() {
    if(!isEmpty() && isBoiled()) {
      empty = true;
    }
  }
 
  //Empty in boiler
  public boolean isEmpty() {
    return empty;
  }
 
  //already boiled in boiler
  public boolean isBoiled() {
    return boiled;
  }
}