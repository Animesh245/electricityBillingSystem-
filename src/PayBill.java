import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.sql.*;


public class PayBill extends JFrame implements ActionListener{
	
	JLabel l1, l2, l3, l4, l5, l6, l11, l12, l13, l14, l15;
	JTextField t1;
	Choice c1, c2;
	JButton b1, b2;
	String meter;
	
	
	
	PayBill(String meter){
		this.meter = meter;

		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		p.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2),"PAY BILL", TitledBorder.LEADING,TitledBorder.TOP,null, new Color(173,216,230)));

        getContentPane().setBackground(Color.WHITE);
		
		
		l1 = new JLabel("Meter No:");
        l1.setBounds(50, 80, 200, 20);
        p.add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(300, 80, 200, 20);
        p.add(l11);
        
        JLabel l2 = new JLabel("Name:");
        l2.setBounds(50, 140, 200, 20);
        p.add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(300, 140, 200, 20);
        p.add(l12);
        
        l3 = new JLabel("Month:");
        l3.setBounds(50, 200, 200, 20);
        p.add(l3);
        
        c1 = new Choice();
        c1.setBounds(300, 200, 200, 20);
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        p.add(c1);
        
        l4 = new JLabel("Units: ");
        l4.setBounds(50, 260, 200, 20);
        p.add(l4);
        
        JLabel l13 = new JLabel();
        l13.setBounds(300, 260, 200, 20);
        p.add(l13);
        
        l5 = new JLabel("Total Bill: ");
        l5.setBounds(50, 320, 200, 20);
        p.add(l5);
        
        JLabel l14 = new JLabel();
        l14.setBounds(300, 320, 200, 20);
        p.add(l14);
        
        l6 = new JLabel("Status: ");
        l6.setBounds(50, 380, 200, 20);
        p.add(l6);
        
        JLabel l15 = new JLabel();
        l15.setBounds(300, 380, 200, 20);
        l15.setForeground(Color.RED);
        p.add(l15);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter_number = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString("meter_number"));
                l12.setText(rs.getString("name"));
            }
            rs = c.s.executeQuery("SELECT * FROM bill_c WHERE meter_number = '"+meter+"' AND month = 'January'");
            while(rs.next()){
                l13.setText(rs.getString("units"));
                l14.setText(rs.getString("total_bill"));
                l15.setText(rs.getString("status"));
            }
        }catch(Exception e){}
        
        
        c1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae){
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("SELECT * FROM bill_c WHERE meter_number = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        l13.setText(rs.getString("units"));
                        l14.setText(rs.getString("total_bill"));
                        l15.setText(rs.getString("status"));
                    }
                }catch(Exception e){}
            }
        });
        
        
        b1 = new JButton("Pay");
        b1.setBounds(100, 460, 100, 25);
        p.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(230, 460, 100, 25);
        p.add(b2);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon("images/pay.png");
        Image i2 = i1.getImage().getScaledInstance(200, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l21 = new JLabel(i3);
        l21.setBounds(400, 120, 600, 300);
        p.add(l21);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
		add(p, "Center");
        
        getContentPane().setBackground(Color.WHITE);  
		setBounds(550, 220, 900, 600);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1){
            try{
                conn c = new conn();
                c.s.executeUpdate("UPDATE bill_c SET status = 'Paid' WHERE meter_number = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
                
            }catch(Exception e){}
            this.setVisible(false);
            new Ekpay(meter);

        }else if(ae.getSource() == b2){
            this.setVisible(false);
            new Project(meter,"").setVisible(true);

        }        
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new PayBill("").setVisible(true);
	}

}
