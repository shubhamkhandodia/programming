import java.util.*;
import java.io.*;
import java.lang.*;
class hello implements Runnable
{
  public void run()
  {
    int n =5;
    for(int i=0;i<n;i++)
    {
      System.out.println(i);
      System.out.println("current running thread is "+Thread.currentThread());
      System.out.println("id of the current thread "+Thread.currentThread().getId());
    }
  }
}
class threadsbasicmethods
{
  public static void main(String[] args) 
  {
    hello m1 = new hello();
    hello m2 = new hello();
    hello m3 = new hello();
    hello m4 = new hello();
    hello m5 = new hello();
    hello m6 = new hello();
    Thread t1 = new Thread(m1);
    Thread t3 = new Thread(m3);
    Thread t4 = new Thread(m4);
    Thread t5 = new Thread(m5);
    Thread t6 = new Thread(m6);

    try{  
          t1.join();  
       }
    catch(Exception e)
       {System.out.println(e.getMessage());}

    //we can also initialize it by name you know

    Thread t2 = new Thread(m2,"mynewthread");
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();

    t6.setName("thread no. 6");
    t3.setPriority(10); //max priority
    t5.setPriority(0);

  }
}