import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4;
	JTextField tf;
	JPasswordField pf;
	JButton b1, b2, b3;
	JPanel p1, p2, p3, p4;
	Choice c1;
	
	Login(){
		super("Login");
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		l1 = new JLabel("Username");
		l1.setBounds(300, 20, 100, 20);
		add(l1);
		
		tf = new JTextField(15);
		tf.setBounds(400, 20, 150, 20);
		add(tf);
		
		l2 = new JLabel("Password");
		l2.setBounds(300, 60, 100, 20);
		add(l2);
		
		pf = new JPasswordField(15);
		pf.setBounds(400, 60, 150, 20);
		add(pf);
		
		c1 = new Choice();
		c1.add("Admin");
		c1.add("Customer");
		c1.setBounds(400, 100, 150, 20);
		add(c1);
		
		l3 = new JLabel("");
		l3.setIcon(new ImageIcon("images/pop.png"));
		l3.setBounds(0, 0, 250, 250);
		add(l3);
		
		l4 = new JLabel("Logging in as");
		l4.setBounds(300, 100, 100, 20);
		add(l4);

		
		
		ImageIcon ic1 = new ImageIcon("images/login.png");
		Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);

		b1 = new JButton("Login", new ImageIcon(i1));
		b1.setBounds(330, 160, 100, 20);
		add(b1);
		
		ImageIcon ic2 = new ImageIcon("images/cancel.jpg");
		Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		
		b2 = new JButton("Cancel", new ImageIcon(i2));
		b2.setBounds(450, 160, 100, 20);
		add(b2);
		
		ImageIcon ic3 = new ImageIcon("images/signup.png");
		Image i3 = ic3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		
		b3 = new JButton("Signup", new ImageIcon(i3));
		b3.setBounds(380, 200, 130, 20);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setLayout(new BorderLayout());
		
		setSize(640, 300);
		setLocation(600,300);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == b1) {
			try {
				conn c = new conn();
				String a = tf.getText();
				String b = pf.getText();
				String user =  c1.getSelectedItem();
				String q = "SELECT * FROM login_c WHERE username = '"+a+"' AND password = '"+b+"' AND user = '"+user+"'";
				ResultSet rs = c.s.executeQuery(q);
				
				if(rs.next()) {
					String meter = rs.getString("meter_no");
					this.setVisible(false);
					new Project (meter, user).setVisible(true);

	
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login");
					tf.setText("");
					pf.setText("");
				}
				
			
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error" + e);
			}
		}
		else if(ae.getSource() == b2) {
			System.exit(0);;
		}
		else if(ae.getSource() == b3) {
			this.setVisible(false);
			new Signup();
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Login().setVisible(true);
	}
	

}
