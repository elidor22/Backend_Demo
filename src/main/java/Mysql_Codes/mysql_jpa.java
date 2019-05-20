package Mysql_Codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysql_jpa {
	 public static void main(String[] args)
	  {
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.cj.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/mytest?serverTimezone=UTC";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "Maya2016!");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM example";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java result-set
	      ResultSet rs = st.executeQuery(query);
	      ResultSet tester;
	      // iterate through the java result-set
	      while (rs.next())
	      {
	        int id = rs.getInt("id");
	        //int column = rs.getInt("column_1");
	        String test = rs.getString("name");
	        
	        // print the results
	        System.out.println("The id is: "+id+"  and the column is:  "+ test);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }
	

}
