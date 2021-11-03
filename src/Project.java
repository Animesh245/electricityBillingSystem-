import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Project extends JFrame implements ActionListener {

	String meter;
	String person;
	Project(String meter, String person){
		
		super("ELectricity Billing System");
		this.meter = meter;
		this.person = person;
		
		/*
		Background Image
		 */
		ImageIcon ic0 = new ImageIcon("images/payra.jpg");
		Image i0 = ic0.getImage().getScaledInstance(1080, 680, Image.SCALE_DEFAULT);
//		ImageIcon ic2 = new ImageIcon(i1);
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon(i0));
		add(l1);
		
		
		/*-------------------Menu bar----------------------------*/
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		setSize(400,400);
		setVisible(true);
		
		/*-----------Master Menu---------------*/
		
		JMenu master = new JMenu("Master");
		JMenuItem m1 = new JMenuItem("New Customer");
		JMenuItem m2 = new JMenuItem("Customer Details");
		JMenuItem m3 = new JMenuItem("Deposit Details");
		JMenuItem m4 = new JMenuItem("Calculate Bill");
		

		master.setForeground(Color.BLUE);
//		
		
		/*--------------------New Customer---------------------------*/
		m1.setFont(new Font("monospaced",Font.BOLD,12));
		ImageIcon ic1 = new ImageIcon("images/signup.png");
		Image i1 = ic1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m1.setIcon(new ImageIcon(i1));
		m1.setMnemonic('D');
		m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		m1.setBackground(Color.WHITE);
		m1.addActionListener(this);
		
		/*-------------------Customer Details----------------------*/
		
		m2.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic2 = new ImageIcon("images/customer.png");
		Image i2 = ic2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m2.setIcon(new ImageIcon(i2));
		m2.setMnemonic('M');
		m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		m2.setForeground(Color.WHITE);
		m2.addActionListener(this);
		
		/*-------------------Deposit Details-----------------------*/
		
		m3.setFont(new Font("monospaced",Font.BOLD,12));
		ImageIcon ic3 = new ImageIcon("images/icon3.png");
		Image i3 = ic3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m3.setIcon(new ImageIcon(i3));
		m3.setMnemonic('N');
		m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		m3.setForeground(Color.WHITE);
		m3.addActionListener(this);
		
		/*------------------Calculate Bill----------------------*/
		
		m4.setFont(new Font("monospaced",Font.BOLD,12));
		ImageIcon ic4 = new ImageIcon("images/icon5.png");
		Image i4 = ic4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m4.setIcon(new ImageIcon(i4));
		m4.setMnemonic('B');
		m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		m4.setForeground(Color.WHITE);
		m4.addActionListener(this);
		
//		Add them in master 
		master.add(m1);
		master.add(m2);
		master.add(m3);
		master.add(m4);
		
		
		/*----------------Information Menu-----------------*/
		JMenu info = new JMenu("Information");
		JMenuItem info1 = new JMenuItem("Update Information");
		JMenuItem info2 = new JMenuItem("View Information");
		

		info.setForeground(Color.BLUE);
		
		
		/*-----------------Update Information--------------*/
		
		info1.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic5 = new ImageIcon("images/icon3.png");
		Image i5 = ic5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		info1.setIcon(new ImageIcon(i5));
		info1.setMnemonic('I');
		info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		info1.setForeground(Color.WHITE);
		info1.addActionListener(this);
		
		/*-----------------View Information--------------*/
		
		info2.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic6 = new ImageIcon("images/info.png");
		Image i6 = ic6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		info2.setIcon(new ImageIcon(i6));
		info2.setMnemonic('V');
		info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		info2.setForeground(Color.WHITE);
		info2.addActionListener(this);
		
		
		/*Add them in information*/
		
		info.add(info1);
		info.add(info2);
		
		
		
		
		/*----------------User Menu-----------------*/
		JMenu user = new JMenu("User");
		JMenuItem ur1 = new JMenuItem("Pay Bill");
		JMenuItem ur2 = new JMenuItem("Bill Details");
		

		user.setForeground(Color.BLUE);
		
		
		/*-----------------Pay Bill--------------*/
		
		ur1.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic7 = new ImageIcon("images/icon4.png");
		Image i7 = ic7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ur1.setIcon(new ImageIcon(i7));
		ur1.setMnemonic('P');
		ur1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		ur1.setForeground(Color.WHITE);
		ur1.addActionListener(this);
		
		/*-----------------Bill Details--------------*/
		
		ur2.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic8 = new ImageIcon("images/icon6.png");
		Image i8 = ic8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ur2.setIcon(new ImageIcon(i8));
		ur2.setMnemonic('L');
		ur2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		ur2.setForeground(Color.WHITE);
		ur2.addActionListener(this);
		
		
		/*Add them in user*/
		
		user.add(ur1);
		user.add(ur2);
		
		
		/*----------------Report Menu-----------------*/
		JMenu report = new JMenu("Report");
		JMenuItem rp1 = new JMenuItem("Generate Bill");

		

		report.setForeground(Color.BLUE);
		
		
		/*-----------------Generate Bill--------------*/
		
		rp1.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic9 = new ImageIcon("images/icon7.png");
		Image i9 = ic9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		rp1.setIcon(new ImageIcon(i9));
		rp1.setMnemonic('R');
		rp1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		rp1.setForeground(Color.WHITE);
		rp1.addActionListener(this);
		
		/*Add them in Report*/
		
		report.add(rp1);
		
		
		
		
		
		
		/*-----------Utility Menu---------------*/
		
		JMenu utility = new JMenu("Utility");
		JMenuItem ut1 = new JMenuItem("Notepad");
		JMenuItem ut2 = new JMenuItem("Calculator");
		JMenuItem ut3 = new JMenuItem("Web Browser");

		

		utility.setForeground(Color.BLUE);
		
		/*-----------------Note pad--------------*/
		
		ut1.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic10 = new ImageIcon("images/notepad.png");
		Image i10 = ic10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ut1.setIcon(new ImageIcon(i10));
		ut1.setMnemonic('C');
		ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		ut1.setForeground(Color.WHITE);
		ut1.addActionListener(this);
		
		
		/*-----------------Calculator--------------*/
		
		ut2.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic11 = new ImageIcon("images/icon9.png");
		Image i11 = ic11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ut2.setIcon(new ImageIcon(i11));
		ut2.setMnemonic('X');
		ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		ut2.setForeground(Color.WHITE);
		ut2.addActionListener(this);
		
		
		/*-----------------Web Browser--------------*/
		
		ut3.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic12 = new ImageIcon("images/edge.png");
		Image i12 = ic12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ut3.setIcon(new ImageIcon(i12));
		ut3.setMnemonic('W');
		ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
		ut3.setForeground(Color.WHITE);
		ut3.addActionListener(this);
		
		
//		Add them in utility 
		utility.add(ut1);
		utility.add(ut2);
		utility.add(ut3);
		
		
		/*-----------Exit Menu---------------*/
		
		JMenu exit = new JMenu("Exit");
		JMenuItem ex1 = new JMenuItem("Logout");

		exit.setForeground(Color.RED);
		
		
		
		/*-----------------Web Browser--------------*/
		
		ex1.setFont(new Font("monospaced", Font.BOLD,12));
		ImageIcon ic13 = new ImageIcon("images/icon11.png");
		Image i13 = ic13.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ex1.setIcon(new ImageIcon(i13));
		ex1.setMnemonic('Z');
		ex1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
		ex1.setForeground(Color.WHITE);
		ex1.addActionListener(this);
		
//		Add them in Exit 
		exit.add(ex1);
		
		if(person == "Admin") {
			mb.add(master);
		}
		else {
			mb.add(info);
			mb.add(user);
			mb.add(report);
		}
		mb.add(utility);
		mb.add(exit);
		
		
		setSize(1080,720);
		setFont(new Font("Senserif",Font.BOLD,16));
		setLayout(new FlowLayout());
		setVisible(false);
		
	}
	


	public void actionPerformed(ActionEvent ae) {
		String msg = ae.getActionCommand();
		if(msg.equals("New Customer")) {
//			this.setVisible(false);
			new NewCustomer(person).setVisible(true);
		}
		else if(msg.equals("Customer Details")) {
//			this.setVisible(false);
			new CustomerDetails(person).setVisible(true);
		}
		else if(msg.equals("Calculate Bill")) {
//			this.setVisible(false);
			new CalculateBill(person).setVisible(true);
		}		
		else if(msg.equals("Deposit Details")) {
//			this.setVisible(false);
			new DepositDetails(person).setVisible(true);
		}
		
		
		
		else if(msg.equals("Update Information")) {
			this.setVisible(false);
			new UpdateInfo(meter).setVisible(true);
		}
		else if(msg.equals("View Information")) {
			this.setVisible(false);
			new ViewInfo(meter).setVisible(true);
		}
		
		
		
		else if(msg.equals("Pay Bill")) {
			this.setVisible(false);
			new PayBill(meter).setVisible(true);
		}
		else if(msg.equals("Bill Details")) {
			new BillDetails(meter).setVisible(true);
		}
		
		
		else if(msg.equals("Generate Bill")) {
//			this.setVisible(false);
			new GenerateBill(meter).setVisible(true);
		}


		
		else if(msg.equals("Notepad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception e) {
			}
		}
		else if(msg.equals("Calculator")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception e) {
			}
		}
		else if(msg.equals("Web Browser")) {
			try {
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
			}catch(Exception e) {
			}
		}
		
		
		
		
		else if(msg.equals("Logout")) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Project("","").setVisible(true);
	}

}
