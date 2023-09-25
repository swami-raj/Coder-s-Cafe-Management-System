
package university.management.system;

/**
 *
 * @author swamiraj
 */
import java.sql.*;

public class connec {
    
    
    
    Connection c;
    Statement s;
    
    connec(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","Kumar@1234");
            s=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
