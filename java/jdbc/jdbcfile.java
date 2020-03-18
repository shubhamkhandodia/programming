import java.util.*;
import java.io.*;
import java.lang.*;
import java.sql.*;
class Main 
{
  static final String jdbcdrivername = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/CODINGGROUND";

   static final String USER = "root";
   static final String PASS = "root";

   static Connection con = null;
   static PreparedStatement presmt = null,presmt2 = null,presmt3 = null;


  public static void main(String[] args) 
  {
    try
    {
      Class.forName(jdbcdrivername);

      //now making a Connection

      con = DriverManager.getConnection(jdbcdrivername,USER,PASS);    //just like php database connec

      //creating a prepared statement object using the connection it is used for creating , dropping a table

      presmt = con.prepareStatement("select * from students");


      //but this alone will not do to get items fro the table we also need a Resultset

      ResultSet result = presmt.executeQuery(); //used for selecting tables

      while(result.next())
      {
        System.out.println(result.getInt(1)+" "+result.getString(2));
      }

      //OR second way to pass the sql query

      String sql = "insert into employees values(?,?)" , sql2 = "update employees set name = ? where age < ?";

      presmt2 = con.prepareStatement(sql);

      //some methods of prepareStatement interface

      presmt2.setInt(1,101);//1 specifies the first parameter in the query for example if the first parameter was age then age will be set to 101

      //similarly

      presmt2.setString(2,"sankalp");     //but this will not do

    
      int i = presmt.executeUpdate();     //now it's properly executed this command is used whenever we want to update records , drop table , inserting , deleting etc. 

      System.out.println(i+"records updated");


      //now working with sql2 statement

      presmt3 = con.prepareStatement(sql3);

      presmt3.setString(1,"shubham");
      presmt3.setInt(2,32);       //these two statements set the parameters for presmt3 which means that it will set the names of people under age 32 to shubham

    }

    catch(SQLException se)  //to catch sql exceptions
    {
      System.out.println(se.getStackTrace());
    }

    catch(Exception e)    //to catch other exceptions
    {
      e.printStackTrace();
    }

    finally
    {
      //here we first terminate all the statements and then the connection in two try catch blocks

      try
      {
        presmt.close();
        presmt2.close();
        presmt3.close();
      }

      catch(SQLException e)
      {
        System.out.println("statement could not be closed");
      }

      try
      {
        con.close();
      }

      catch(SQLException se2)
      {
        se2.printStackTrace();
      }
    }
  }
}