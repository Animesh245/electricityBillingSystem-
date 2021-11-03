import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.sql.*;


public class CalculateBill extends JFrame implements ActionListener{

	JLabel l1, l2, l3, l4, l5, l6, l7;
	JTextField t1;
	Choice c1, c2;
	JButton b1, b2;
	JPanel p;
	String person;
	
	CalculateBill(String person){
		this.person = person;
//		p = new JPanel();
//		p.setLayout(null);
//		p.setBackground(new Color(173,216,230));
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		p.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2),"CALCULATE ELECTRICITY BILL", TitledBorder.LEADING,TitledBorder.TOP,null, new Color(173,216,230)));

        getContentPane().setBackground(Color.WHITE);
		
		l1 = new JLabel("Calculate Electricity Bill");
        l1.setBounds(30, 10, 400, 30);
        
        l2 = new JLabel("Meter No:");
        l2.setBounds(60, 70, 100, 30);
        
        l6 = new JLabel("Name:");
        l6.setBounds(60, 120, 100, 30);
        
        l7 = new JLabel("Address:");
        l7.setBounds(60, 170, 100, 30);
        
        l3 = new JLabel("Units Consumed:");
        l3.setBounds(60, 220, 100, 30);
        
        l5 = new JLabel("Month:");
        l5.setBounds(60, 270, 100, 30);
		
		
        c1 = new Choice();
        c1.setBounds(200, 70, 180, 20);
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer");
            while(rs.next()){
                c1.add(rs.getString("meter_number"));
            }
        }catch(Exception e){}
        
        JLabel l11 = new JLabel();
        l11.setBounds(200, 120, 180, 20);
        p.add(l11);
        
        JLabel l12 = new JLabel();
        l12.setBounds(200, 170, 180, 20);
        p.add(l12);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter_number = '"+c1.getSelectedItem()+"'");
            while(rs.next()){
                l11.setText(rs.getString("name"));
                l12.setText(rs.getString("address"));
            }
        }catch(Exception e){}
        
        c1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter_number = '"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        l11.setText(rs.getString("name"));
                        l12.setText(rs.getString("address"));
                    }
                }catch(Exception e){}
            }
        });
        
        t1 = new JTextField();
        t1.setBounds(200, 220, 180, 20);
        
        
        c2 = new Choice();
        c2.setBounds(200, 270, 180, 20);
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        
        b1 = new JButton("Submit");
        b1.setBounds(100, 350, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(230, 350, 100, 25);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon("images/hicon2.jpg");
        Image i2 = i1.getImage().getScaledInstance(200, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l4 = new JLabel(i3);
        l4.setBounds(500, 70, 200, 300);
        
        l1.setFont(new Font("Senserif",Font.PLAIN,26));
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        
//        p.add(l1);
        p.add(l2);
        p.add(l4);
        p.add(l6);
        p.add(l7);
        p.add(c1);
        p.add(l5);
        p.add(c2);
        p.add(l3);
        p.add(t1);
        p.add(b1);
        p.add(b2);
        
        setLayout(new BorderLayout(30,30));
        
        


        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
		add(p, "Center");
        setSize(750, 500);
        setLocation(550, 220);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		 if(ae.getSource() == b1){
	            String meter_no = c1.getSelectedItem();
	            String units = t1.getText();
	            String month = c2.getSelectedItem();

	            int units_consumed = Integer.parseInt(units);

	            int total_bill= 0; int cu= 0; int rent= 0 ; int  scharge = 0; int  mcharge= 0; int  dcharge = 0; int vat = 0;
	            try{
	                conn c = new conn();
	                ResultSet rs = c.s.executeQuery("SELECT * FROM tax_c");
	                while(rs.next()){
//	                    total_bill = units_consumed * Integer.parseInt(rs.getString("cost_per_unit")); /* + Integer.parseInt(rs.getString("meter_rent")) + Integer.parseInt(rs.getString("service_charge")) + Integer.parseInt(rs.getString("minimum_charge")) + Integer.parseInt(rs.getString("demand_charge")) + Integer.parseInt(rs.getString("vat")); // 120 * 7  */
//	                    total_bill += Integer.parseInt(rs.getString("meter_rent"));
//	                    total_bill += Integer.parseInt(rs.getString("service_charge"));
//	                    total_bill += Integer.parseInt(rs.getString("minimum_charge"));
//	                    total_bill += Integer.parseInt(rs.getString("demand_charge"));
//	                    total_bill += Integer.parseInt(rs.getString("vat"));
	                    
	                    cu = rs.getInt("cost_per_unit");
	                   rent = rs.getInt("meter_rent");
	                   scharge = rs.getInt("service_charge");
	                   mcharge = rs.getInt("minimum_charge");
	                   dcharge = rs.getInt("demand_charge");
	                   vat = rs.getInt("vat");
	                }
	            }catch(Exception e){}
		 
	            total_bill = (units_consumed * cu) + rent + scharge + mcharge + dcharge + vat;
	            String q = "INSERT INTO bill_c VALUES('"+meter_no+"','"+month+"','"+units+"','"+total_bill+"', 'Not Paid')";

	            try{
	                conn c1 = new conn();
	                c1.s.executeUpdate(q);
	                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
	                this.setVisible(false);
	            }catch(Exception aee){
	                aee.printStackTrace();
	            }

	        }else if(ae.getSource() == b2){
	            this.setVisible(false);
	            
	        }        
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new CalculateBill("").setVisible(true);
	}

}
