//import java.sql.*;
//
//public class conn {
//	Connection c;
//	Statement s;
//	
//	public conn(){
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			c = DriverManager.getConnection("jdbc:mysql:///project3", "root", "Amarsql");
//			s = c.createStatement();
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}



import java.sql.*;

public class conn{
	
	Connection c;
	Statement s;
	
	public conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/EBS","root","Amarsql");
			System.out.println("Connection is established successfully!");
			
			s = c.createStatement();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}







































