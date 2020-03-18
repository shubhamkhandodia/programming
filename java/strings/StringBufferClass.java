import java.util.*;
import java.io.*;
import java.lang.*;
class StringBufferClass {
  public static void main(String[] args) 
  {
    //how to declare ?
    String y = new String("nikka");
    StringBuffer x = new StringBuffer(y);
    System.out.println(x);//before using append
    x.append("what?");//this will work because stringbuffer is mutable
    System.out.println(x);

    //how to convert it into string again ?
    String converted = x.toString();

    System.out.println(converted);


    //IMPORTANT METHODS
    x.insert(1, "sa");

    System.out.println("afer inserting on index 1(excluded)"+x);

    x.replace(2, 5, " replaced string "); //simlarly we have delete also

    System.out.println("afer replacing from index 2 to 5(excluded)"+x);

    x.reverse();

    System.out.println("afer reversing"+x);
    
  }
}