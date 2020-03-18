class Bike
{  
  void run(int x,int y){System.out.println("running"+x+y);}  
}  
class Splendor extends Bike
{  
  void run(int x){System.out.println("running safely with 60km"+x);}    
}

class Polymorphism
{
  public static void main(String args[])
  {  
    Bike b = new Splendor();//an example of upcasting  
    b.run(10,5);

    // Bike b2 = new Bike();
    // b2.run(16);             //it will give error

    Splendor s = new Splendor();

    s.run(6);

    // Splendor s2 = new Bike();    //error because there is no such thing as downcasting

    // s2.run(8);
  }
}