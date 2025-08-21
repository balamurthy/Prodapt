package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
   public class jdbcConnection
   {
       @SuppressWarnings("deprecation")
	public static void main (String[] args)
       {
           System.out.println("\n\n***** MySQL JDBC Connection Testing *****");
		   Connection conn = null;
           try
           {
        	   
		       java.sql.Driver d=new com.mysql.cj.jdbc.Driver();
        	   d.connect("com.mysql.cj.jdbc.Driver",null);
        	   String userName = "root";
               String password = "root_new";
               String url = "jdbc:MySQL://localhost:3306/sakila";    
               conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("\nDatabase Connection Established...");
               
               String sql = "select country_id,country from country where country = 'India'";
               java.sql.Statement stmt  = conn.createStatement();
               ResultSet rs    = stmt.executeQuery(sql);
             
              // loop through the result set
              while (rs.next()) {
                  System.out.println(rs.getInt("country_id") + " " + rs.getString("country"));
                      
              }
          
           }
           
          catch (Exception ex)
           {
		       System.err.println ("Cannot connect to database server");
			   ex.printStackTrace();
           }      
		   
		   finally
           {
               if (conn != null)
               {
                   try
                   {
                       System.out.println("\n***** Let terminate the Connection *****");
					   conn.close ();					   
                       System.out.println ("\nDatabase connection terminated...");
                   }
                   catch (Exception ex)
				   {
				   System.out.println ("Error in connection termination!");
				   }
               }
           }
       }
   }
