import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class CustomerDetails extends JFrame implements ActionListener{

	JTable t1;
	JButton b1;
	String x[] = {"Customer Name", "Meter Number", "Address", "District","Postcode", "Email", "Phone"};
	String y[][] = new String[40][8];
	int i = 0, j = 0;
	
	String person;
	
	/*Constructor*/
	CustomerDetails(String person){
		super("Customer Details");
		this.person = person;
		setSize(1200, 750);
		setLocation(400,150);

	
	try {
		conn c1 = new conn();
		String q = "SELECT * FROM customer";
		ResultSet rs = c1.s.executeQuery(q);
		
		while(rs.next()) {
			y[i][j++] = rs.getString("name");
			y[i][j++] = rs.getString("meter_number");
			y[i][j++] = rs.getString("address");
			y[i][j++] = rs.getString("district");
			y[i][j++] = rs.getString("postcode");
			y[i][j++] = rs.getString("email");
			y[i][j++] = rs.getString("phone");
			i++;
			j = 0;
			
		}
		
		t1 = new JTable(y,x);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	b1 = new JButton("Print");
	add(b1,"South");
	b1.addActionListener(this);
	
	JScrollPane sp = new JScrollPane(t1);
	add(sp);
	
	

//	setLayout(new FlowLayout());

	setVisible(true);
	}
	
	
	
	

	
	public void actionPerformed(ActionEvent ae) {

		try {
			t1.print();
		}
		catch(Exception e) {
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new CustomerDetails("").setVisible(true);
	}

}
