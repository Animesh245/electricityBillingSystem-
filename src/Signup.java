import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5, l6;
	JPanel p1;
	JTextField tf1, tf2, tf3, tf4;
	Choice c1;
	JButton b1, b2;
	
	Signup(){
//		super("Signup");
		
//		setBounds(600, 250,700,400);
		
		p1 = new JPanel();
		p1.setBounds(30,30,650,300);
		p1.setLayout(null);
		p1.setForeground(Color.WHITE);
		p1.setBackground(Color.WHITE);
		p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2),"CREATE ACCOUNT", TitledBorder.LEADING,TitledBorder.TOP,null, new Color(173,216,230)));
		add(p1);
		
		l1 = new JLabel("Username: ");
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(100, 50, 100, 20);
		p1.add(l1);
		
		tf1 = new JTextField();
		tf1.setBounds(250, 50, 150, 20);
		p1.add(tf1);
		
		l2 = new JLabel("Name: ");
		l2.setForeground(Color.DARK_GRAY);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setBounds(100, 80, 100, 20);
		p1.add(l2);
		
		tf2 = new JTextField();
		tf2.setBounds(250, 80, 150, 20);
		p1.add(tf2);
		
		l3 = new JLabel("Password: ");
		l3.setForeground(Color.DARK_GRAY);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setBounds(100, 110, 100, 20);
		p1.add(l3);
		
		tf3 = new JTextField();
		tf3.setBounds(250, 110, 150, 20);
		p1.add(tf3);
		
		l4 = new JLabel("Create account as: ");
		l4.setForeground(Color.DARK_GRAY);
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setBounds(100, 140, 150, 20);
		p1.add(l4);
		
		c1 = new Choice();
		c1.add("Admin");
		c1.add("Customer");
		c1.setBounds(250, 140, 150, 20);
		p1.add(c1);
		
		l5 = new JLabel("Meter Number: ");
		l5.setForeground(Color.DARK_GRAY);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setBounds(100, 170, 200, 20);
		l5.setVisible(false);
		p1.add(l5);
		
		tf4 = new JTextField();
		tf4.setBounds(250, 170, 150, 20);
		tf4.setVisible(false);
		p1.add(tf4);
		
		l6 = new JLabel("");
		l6.setIcon(new ImageIcon("images/signup.png"));
		l6.setBounds(450,30,250,250);
		p1.add(l6);
		
		b1 = new JButton("Create");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(150, 290, 120, 30);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(300, 290, 120, 30);
		b2.addActionListener(this);
		p1.add(b2);
		
		c1.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent ie) {
			String user = c1.getSelectedItem();
			if(user == "Customer") {
				l5.setVisible(true);
				tf4.setVisible(true);
			}else
			{
				l5.setVisible(false);
				tf4.setVisible(false);
			}
				
			}
			
		});

		setSize(700,400);
		setLocation(600,250);
		setVisible(true);
	}
	
	
	
	public void actionPerformed( ActionEvent ae) {
		if(ae.getSource() == b1) {
			
			String username = tf1.getText();
			String name = tf2.getText();
			String password = tf3.getText();
			String meterNo = tf4.getText();
			String user = c1.getSelectedItem();
			
			try {
				conn c = new conn();
				String str = null;
				String str2 = null;
				
				if(user.equals("Admin")) {
					str = "INSERT INTO login_c VALUES('"+null+"','"+username+"','"+name+"', '"+password+"', '"+user+"')";
					
					c.s.executeUpdate(str);

					
				}
				else {
					str2 = "UPDATE login_c SET username = '"+username+"', name = '"+name+"', password = '"+password+"', user = '"+user+"' WHERE meter_no = '"+meterNo+"'";
					str = "INSERT INTO login_c VALUES('"+meterNo+"','"+username+"','"+name+"', '"+password+"', '"+user+"')";
				
					c.s.executeUpdate(str);
					c.s.executeUpdate(str2);
				}
	
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				this.setVisible(false);
				new Login().setVisible(true);

				
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error"+ e);
			}
			
			
			
		}
		else if(ae.getSource() == b2) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
	}

	
	
	
	/*
	  launch
	  */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Signup().setVisible(true);
	}

}
