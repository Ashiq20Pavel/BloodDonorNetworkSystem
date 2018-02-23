/**
 	Here is the code of Database Connector!
 	
 	@author team Blood_Donor_Network_System
 	@version 2.6
 	@see java.lang.object
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
//import java.sql.SQLException;
import com.mysql.jdbc.*;

public class DatabaseConnection{
	
	
		Connection con = null;
		public static Connection dbConnector(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost/blood_donor","root","");
			
            return con;  
		}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Cannot connect to database.");
			System.out.println("E1");
			return null;
		}
		
	}
}
