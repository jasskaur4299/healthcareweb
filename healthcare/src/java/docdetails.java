import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import comm.Doc;

public class docdetails extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
           
        // JDBC driver name and database URL
      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      final String DB_URL="jdbc:mysql://localhost/Healthcare";

      //  Database credentials
       final String USER = "root";
      final String PASS = "root";

      
      out.println("<!doctype html> <html><head><title></title></head><body bgcolor = '#f0f0f0'><h1 align = 'center'></h1>");

      
      
      Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql;
         sql = "SELECT * FROM Doc";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            String id = rs.getString("id");
            String name = rs.getString("name");
            String password = rs.getString("password");
            
            String contact = rs.getString("contact");
            String dob = rs.getString("dob");

            //Display values
            out.println("ID: " + id + "<br>");
            out.println("NAME: " + name + "<br>");
            out.println("PASSWORD: " + password + "<br>");
            out.println("CONTACT: " + contact + "<br>");
            out.println("DOB: " + dob + "<br>");
           
         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      }
      catch(SQLException se) 
      {
         //Handle errors for JDBC
         se.printStackTrace();
      } 
        catch(Exception e) 
        {
         //Handle errors for Class.forName
         e.printStackTrace();
      }   
}
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
        {
        
        }

}

