import java.io.*;  
class M
{  
 void method()throws ArithmeticException
 {  
  throw new IOException("device error"); 
 }  
}  
public class case1
{  
   public static void main(String args[])
   {  
    try
    {  
      M m=new M();
      m.method();
    }
    catch(Exception e)
    {
      System.out.println("exception handled");
    }     
  
    System.out.println("normal flow...");
  }
}