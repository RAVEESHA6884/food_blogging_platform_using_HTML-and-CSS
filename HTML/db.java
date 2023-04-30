import java.sql.*;

public class JdbcExample {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/DBNAME";
   static final String USER = "system";
   static final String PASS = "rs";

   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;
      try{
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);

         // Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL,USER,PASS);

         // Execute a query
         System.out.println("Creating statement...");
         stmt = conn.createStatement();
         String sql;
         sql ="insert into signuppage(&username,&email,&password,&confirmpassword)values(?,?,?,?)";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            String username = rs.putString("username");
            String email = rs.putString("email");
            String password = rs.putString("password");
            String confirmpassword = rs.putString("confirmpassword");
        
         }
         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      }catch(SQLException se){
         // Handle errors for JDBC
         se.printStackTrace();
      }catch(Exception e){
         // Handle errors for Class.forName
         e.printStackTrace();
      }finally{
         // Finally block used to close resources
         try{
            if(stmt!=null)
               stmt.close();
         }catch(SQLException se2){
         } // nothing we can do
         try{
            if(conn!=null)
            conn.close();
         }catch(SQLException se){
            se.printStackTrace();
         } // end finally try
      } // end try
      System.out.println("Goodbye!");
   } // end main
} // end JDBCExample
