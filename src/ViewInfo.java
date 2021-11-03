import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewInfo extends JFrame implements ActionListener{

    JButton b1;
    String meter;
    
	ViewInfo(String meter){
		this.meter = meter;
//		setBounds(600,250, 850, 650);
//        getContentPane().setBackground(Color.WHITE);

        
        JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		p.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2),"VIEW CUSTOMER INFORMATION", TitledBorder.LEADING,TitledBorder.TOP,null, new Color(173,216,230)));
		add(p);
        getContentPane().setBackground(Color.WHITE);
        
        
//        JLabel title = new JLabel("VIEW CUSTOMER INFORMATION");
//        title.setBounds(250, 0, 500, 40);
//        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        p.add(title);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(70, 80, 200, 20);
        p.add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(250, 80, 200, 20);
        p.add(l11);
        
        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(70, 140, 200, 20);
        p.add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(250, 140, 200, 20);
        p.add(l12);
        
        JLabel l3 = new JLabel("Address");
        l3.setBounds(70, 200, 300, 20);
        p.add(l3);
        
        JLabel l13 = new JLabel();
        l13.setBounds(250, 200, 200, 20);
        p.add(l13);
        
        JLabel l4 = new JLabel("District");
        l4.setBounds(70, 260, 200, 20);
        p.add(l4);
        
        JLabel l14 = new JLabel();
        l14.setBounds(250, 260, 200, 20);
        p.add(l14);
        
        JLabel l5 = new JLabel("Postcode");
        l5.setBounds(70, 320, 200, 20);
        p.add(l5);
        
        JLabel l15 = new JLabel();
        l15.setBounds(250, 320, 200, 20);
        p.add(l15);
        
        JLabel l6 = new JLabel("Email");
        l6.setBounds(70, 380, 200, 20);
        p.add(l6);
        
        JLabel l16 = new JLabel();
        l16.setBounds(250, 380, 200, 20);
        p.add(l16);
        
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(70, 440, 200, 20);
        p.add(l7);
        
        JLabel l17 = new JLabel();
        l17.setBounds(250, 440, 200, 20);
        p.add(l17);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter_number = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                l13.setText(rs.getString(3));
                l14.setText(rs.getString(4));
                l15.setText(rs.getString(5));
                l16.setText(rs.getString(6));
                l17.setText(rs.getString(7));
                
            }
        }catch(Exception e){}
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350, 500, 100, 25);
        b1.addActionListener(this);
        p.add(b1);
        
        ImageIcon i1 = new ImageIcon("images/adduser.png");
        Image i2 = i1.getImage().getScaledInstance(160, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8  = new JLabel(i3);
//        l8.setIcon(new ImageIcon("images/adduser.png"));
        l8.setBounds(600, 100, 160, 180);
        p.add(l8);
        
//		setBounds(600,250, 850, 650);
		setLocation(600, 250);
		setSize(850, 650);
		setVisible(true);
        setLayout(null);
	}
	
	public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
        new Project(meter,"").setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ViewInfo("").setVisible(true);
	}

}
