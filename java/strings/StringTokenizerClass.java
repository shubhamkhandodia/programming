import java.util.*;
import java.io.*;
import java.lang.*;
class StringTokenizerClass {
  public static void main(String[] args) 
  {
    //HOW TO CREATE
    String y = "orange is the new black";
    StringTokenizer x = new StringTokenizer(y,"n");

    while(x.hasMoreTokens())
    {
      System.out.println(x.nextToken());
    }
  }
}