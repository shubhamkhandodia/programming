import java.io.*;
import java.net.*;

class Server 
{
  public static void main(String[] args) 
  {

    try
    {
      ServerSocket ss = new ServerSocket(6666);
      Socket client = ss.accept();   //accept method of serversocket class establishes a connection returns a socket type object

      //now receive the input stream form this socket object

      DataInputStream inputdata = new DataInputStream(client.getInputStream());
      DataOutputStream outputdata = new DataOutputStream(client.getOutputStream());


      BufferedReader y1 = new BufferedReader(new InputStreamReader(System.in));

      String string1 = "", messagestring = "";

      while(!messagestring.equals("stop"))
      {
        messagestring = inputdata.readUTF();      //utf means nothing it just reads the string in utf8 encoding

        System.out.println("Client says :"+messagestring);

        string1 = y1.readLine();

        outputdata.writeUTF(string1);

        outputdata.flush();
      }

      inputdata.close();
      client.close();
      ss.close();   //close the server socket connection using synchronized close method
    }

    catch(ConnectException ce)
    {
      System.out.println("server side exception : could not connect");
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