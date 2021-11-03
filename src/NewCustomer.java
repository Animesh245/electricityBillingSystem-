import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.sql.*;
import java.util.*;


public class NewCustomer extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton b1,b2;
	String person;
	
	NewCustomer(String person){
		this.person = person;
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		p.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2),"NEW CUSTOMER", TitledBorder.LEADING,TitledBorder.TOP,null, new Color(173,216,230)));
		add(p, "Center");
        getContentPane().setBackground(Color.WHITE);
		

		
		l1 = new JLabel("Customer Name: ");
		l1.setBounds(100, 80, 200, 20);
		p.add(l1);
		
        tf1 = new JTextField();
        tf1.setBounds(240, 80, 200, 20);
        p.add(tf1);
		
		l2 = new JLabel("Meter No: ");
        l2.setBounds(100, 120, 100, 20);
        p.add(l2);
        
        tf2 = new JTextField();
        tf2.setBounds(240, 120, 200, 20);
        p.add(tf2);
        
        l3 = new JLabel("Address: ");
        l3.setBounds(100, 160, 100, 20);
        p.add(l3);
        
        tf3 = new JTextField();
        tf3.setBounds(240, 160, 200, 20);
        p.add(tf3);
        
        
        l4 = new JLabel("District: ");
        l4.setBounds(100, 200, 100, 20);
        p.add(l4);
        
        tf4 = new JTextField();
        tf4.setBounds(240, 200, 200, 20);
        p.add(tf4);
        
        l5 = new JLabel("Postcode: ");
        l5.setBounds(100, 240, 100, 20);
        p.add(l5);
        
        tf5 = new JTextField();
        tf5.setBounds(240, 240, 200, 20);
        p.add(tf5);
        
        l6 = new JLabel("Email: ");
        l6.setBounds(100, 280, 100, 20);
        p.add(l6);
        
        tf6 = new JTextField();
        tf6.setBounds(240, 280, 200, 20);
        p.add(tf6);
        
        l7 = new JLabel("Phone Number: ");
        l7.setBounds(100, 320, 100, 20);
        p.add(l7);
        
        tf7 = new JTextField();
        tf7.setBounds(240, 320, 200, 20);
        p.add(tf7);
        

        
        ImageIcon ic1 = new ImageIcon("images/hicon1.jpg");
        Image i1 = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        l8 = new JLabel("");
        l8.setBounds(500, 80, 150, 300);
        l8.setIcon(new ImageIcon(i1));
        p.add(l8);
        
        
        

        

		
        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
//        l11.setText("" + Math.abs(first));
		JLabel l11 = new JLabel(""+ Math.abs(first));
		l11.setBounds(240, 120, 200, 20);
		l11.setFont(new Font("Tahoma", Font.PLAIN, 24));;
//		p.add(l11);

        
        b1 = new JButton("Submit");
        b1.setBounds(120, 390, 100, 25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(250, 390, 100, 25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p.add(b2);
        

      

        

        

//        setLayout(new BorderLayout());
		setLocation(600,200);
		setSize(700, 500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1) {
			String name = tf1.getText();
//			String meter = l11.getText();
			String meter = tf2.getText();
			String address = tf3.getText();
			String district = tf4.getText();
			String postcode = tf5.getText();
			String email = tf6.getText();
			String phone = tf7.getText();
			
			String q1 = "INSERT INTO customer VALUES('"+name+"','"+meter+"','"+address+"','"+district+"','"+postcode+"','"+email+"','"+phone+"')";
			
			String q2 = "INSERT INTO login_c VALUES('"+meter+"','','','','')";
		
			try {
				conn c1 = new conn();
				c1.s.executeUpdate(q1);
				c1.s.executeUpdate(q2);
				
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				this.setVisible(false);
				new MeterInfo(meter);
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(ae.getSource() == b2) {
			this.setVisible(false);
			new Project("",person).setVisible(true);

		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new NewCustomer("").setVisible(true);;
	}

}
