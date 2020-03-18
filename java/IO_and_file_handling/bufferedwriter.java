import java.io.*;
import java.util.*;
class bufferedwriter 
{
  public static void main(String[] args) throws IOException 
  {
    FileWriter v = new FileWriter("./file1.txt",true); //true means new data will be appended
    BufferedWriter x = new BufferedWriter(v);

    x.write("you're my pumpkin-pumpkin hello honey bunny");
    x.close();
  }
}