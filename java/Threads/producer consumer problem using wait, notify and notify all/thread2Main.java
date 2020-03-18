import java.awt.List;
import java.util.*;
import java.io.*;
import java.lang.*;

//what does this program do ?
// producer thread produces a new resource in every 1 second and put it in taskQueue
// Consumer thread takes 1 seconds to process consumed resource from ‘taskQueue’.
// Max capacity of taskQueue is 5 i.e. maximum 5 resources can exist inside ‘taskQueue’ at any given time.
// Both threads run infinitely.

class producer implements Runnable
{
  private final ArrayList<Integer> taskQueue;
  private final int MAX_CAPACITY;

  public producer(ArrayList<Integer> sharedQueue, int size)
  {
    this.taskQueue = sharedQueue;
    this.MAX_CAPACITY = size;
  }

  public void produce(int i)throws InterruptedException
  {
    synchronized(taskQueue)
    {
      while(taskQueue.size() == MAX_CAPACITY)
      {
        System.out.println("task queue is full "+Thread.currentThread());
        taskQueue.wait();
      }

      Thread.sleep(1000);
      taskQueue.add(i);   //new task added
      System.out.println("Produced: " + i);
      taskQueue.notifyAll();  // so that all the consumer threads waiting on this resource can wake up
    }
  }

  public void run()
  {
    int counter = 0;
    while(true)
    {
      try
      {
        produce(counter++);
      }
      catch(InterruptedException ex)
      {
        ex.printStackTrace();
      }
    }
  }
}

class Consumer implements Runnable
{
  private final ArrayList<Integer> taskQueue;

  public Consumer(ArrayList<Integer> sharedQueue)
  {
    this.taskQueue = sharedQueue;
  }

  private void consume() throws InterruptedException
   {
      synchronized (taskQueue)
      {
         while (taskQueue.isEmpty())
         {
            System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
            taskQueue.wait();
         }
         Thread.sleep(1000);
         int i = (Integer) taskQueue.remove(0);
         System.out.println("Consumed: " + i);
         taskQueue.notifyAll();
      }
   }

   public void run()
   {
      while (true)
      {
         try
         {
            consume();
         } catch (InterruptedException ex)
         {
            ex.printStackTrace();
         }
      }
   }
}

class thread2Main 
{
  public static void main(String[] args) 
  {
      ArrayList<Integer> taskQueue = new ArrayList<Integer>();
      int MAX_CAPACITY = 5;
      Thread tProducer = new Thread(new producer(taskQueue, MAX_CAPACITY), "Producer");
      Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
      tProducer.start();
      tConsumer.start();
  }
}