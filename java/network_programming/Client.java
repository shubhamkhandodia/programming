import java.io.*;
import java.net.*;

class Client 
{
  public static void main(String[] args) 
  {

    try
    {
      
      Socket client = new Socket("localhost",6666); 

      //now receive the input stream form this socket object

      DataInputStream inputdata = new DataInputStream(client.getInputStream());
      DataOutputStream outputdata = new DataOutputStream(client.getOutputStream());

      BufferedReader y1 = new BufferedReader(new InputStreamReader(System.in));

      String string1 = "", messagestring = "";

      while(!messagestring.equals("stop"))
      {
        messagestring = y1.readLine();

        outputdata.writeUTF(messagestring);

        outputdata.flush();

        string1 = inputdata.readUTF();

        System.out.println("Server replies :"+string1);
      }

      inputdata.close();
      client.close();
    }

    catch(ConnectException ce)
    {
      System.out.println("client side exception : could not connect");
      ce.printStackTrace();
    }

    catch(IOException ioex)
    {
      ioex.printStackTrace();
    }

    catch(Exception e)
    {
      e.printStackTrace();
    }
    
  }
}