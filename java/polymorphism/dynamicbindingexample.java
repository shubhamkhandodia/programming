import java.util.*;
import java.io.*;
import java.lang.*;
class Animal{  
 void eat(){System.out.println("animal is eating...");}  //if i make it private , final or static it will show compilation error
}  
  
class Dog extends Animal{  
 void eat(){System.out.println("dog is eating...");}   
}

class dynamicbindingexample{
  public static void main(String args[])
  {  
    Animal a=new Dog();  
    a.eat();  
  }
 }