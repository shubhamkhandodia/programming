import java.io.*;
import java.util.*;
class bufferedreader 
{
  public static void main(String[] args) throws IOException
  {
    int ch;
    FileReader v = new FileReader("./file1.txt"); //true means new data will be appended
    BufferedReader x = new BufferedReader(v); //we can have two arguments i.e buffer size in this case it will take default size of the buffer

    while((ch = x.read()) != -1)  //reading every char form the file until the end (-1 char indicates the end of the file)
    {
      System.out.print((char)ch); //typecasting every character read from the buffer to char data type
    }

    x.close();
  }
}