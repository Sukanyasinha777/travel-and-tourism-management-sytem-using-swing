
package tourism.management.system;
import java.sql.*; //for connection class

public class Conn {
    
    Connection c; //establish connection with dbms
    Statement s;
   Conn(){
try{
    Class.forName("com.mysql.cj.jdbc.Driver"); //getting driver class from jdbc
    c=DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","NOMORETRUST@777");
    s=c.createStatement();
    
}   catch(Exception e){
    e.printStackTrace();
}    

   }
}
