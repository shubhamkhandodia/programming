import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.String;
public class StringMain{

  public static void main(String[] args)
  {

    //STRING CREATION

    //two types of techniques to create a new String
    String x = "sachin";
    String x2 = "Sachin";
    String y = new String("satan");
    String ye = new String("sachin");
    String u = new String("good morning");

    //create a string from a char

    char xe = 'e';

    String fromchar = Character.toString(xe);

    //creating string from a char array

    char[] ch = {'g', 'o', 'o', 'd', ' ', 'm', 'o', 'r', 'n', 'i', 'n', 'g'};
    String str = new String(ch);

    //converting string to char

    char sw = x.charAt(1);


    //STRING COMPARISON

    //first method : using equals method (only looks for the actual string)

    boolean z = ch.equals(u);

    System.out.println(z);

    //second method : using == operator (looks if the two strings are pointing to the same object)

    if(x==ye)
    System.out.println("strings point to the same object");

    else
    System.out.println("strings do not point to the same object");

    //third method : using compareTo method (gives positive value if not in dictionary order 0 if same and -ve if in dictionary order)

    System.out.println(x.compareTo(str)); //str contains good morning and x contains sachin so output is 12
                                          //explanation : s is 12 places ahead of g(g is not counted but s is)
    									  //similarly str.compareTo(x) will give -12

    //what happens when one s is small and other one is capital ?
    //Ans. 32 because difference between the ascii values 
    System.out.println(x.compareTo(x2)); //x is sachin and x2 is Sachin

    //what if i make S as R
    //Ans. 33 (32+1)
    //what if i make S as T
    //Ans. 31 (32-1)


    //STRING CONCATENATION

    String pe = x.concat(x2);
    String xr = x+str;

    System.out.println(pe);
    System.out.println(xr);

    //SUBSTRING EXTRACTION

    //two methods : one only containing starting index and other containing both start and end index
    //(start inclusive and end exclusive)

    String s="hello";  
    System.out.println(s.substring(0,2));//he

    //IMPORTANT METHODS OF STRING class

    int length = s.length(); //length

    //a method to convert any datatype into string
    //actually a very important method , it can also convert a char array into string

    String anyvalue;

    int xc=5;
    float yz=7;
    double n=16;
    long m=2343647;

    anyvalue = String.valueOf(xc)+" "+String.valueOf(yz)+" "+String.valueOf(n)+" "+String.valueOf(m);

    System.out.println(anyvalue);

    char[] x1 = {'a','b','c'};

    String stringusingchararray = String.valueOf(x1);

    //replace method

    u.replace("morning", "night"); //not gonna work becuse strings are immutable biaaatch
    String replacestring = u.replace("morning", "night"); //so we have to explicitly declare it into another string object

    System.out.println(replacestring);

    //split

    String splitexample = "english muthafucka do you speak it ?";

    String[] splitexamplearray = splitexample.split(" ");

    for(String w:splitexamplearray)
    {
      System.out.println(w);
    }
  }
}