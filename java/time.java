import java.util.*;
import java.text.SimpleDateFormat;
class time 
{
  public static void main(String[] args) 
  {
     Date currentTime = Calendar.getInstance().getTime();

    String pattern = "HH";
    SimpleDateFormat df = new SimpleDateFormat(pattern);

    String todayAsString = df.format(currentTime);
    System.out.print(todayAsString);
  }
}