import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.sql.*;


public class GenerateBill extends JFrame implements ActionListener{

    JLabel l1, l2;
    JTextArea t1;
    JButton b1;
    Choice c2;
    JPanel p1;
    String meter;
	
	GenerateBill(String meter){
        this.meter = meter;
        setSize(500,900);
        setLayout(new BorderLayout());
        
p1 = new JPanel();
//p1.setLayout(null);
//p1.setBackground(Color.WHITE);
//p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2),"GENERATE BILL", TitledBorder.LEADING,TitledBorder.TOP,null, new Color(173,216,230)));

getContentPane().setBackground(Color.WHITE);



        l1 = new JLabel("Generate Bill");
        
        l2 = new JLabel(meter);
        
        c2 = new Choice();
        
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

        
        t1 = new JTextArea(50,15);
        t1.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\the bill of the Selected Month\n\n");
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif",Font.ITALIC,18));
        
        b1 = new JButton("Generate Bill");
        
        
        p1.add(l1);
        p1.add(l2);
        p1.add(c2);
        add(p1, "North");
        
        add(jsp,"Center");
        add(b1,"South");
        
        b1.addActionListener(this);
        
        setLocation(750,100);

        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try{
            conn c = new conn();
   
            String month = c2.getSelectedItem();
            t1.setText("\tSummit Power Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+" ,2021\n\n\n");
            
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter_number=" + meter);
            
            if(rs.next()){
                t1.append("\n    Customer Name: "+rs.getString("name"));
                t1.append("\n    Meter Number:  "+rs.getString("meter_number"));
                t1.append("\n    Address:       "+rs.getString("address"));
                t1.append("\n    District:      "+rs.getString("district"));
                t1.append("\n    Postcode:      "+rs.getString("postcode"));
                t1.append("\n    Email:         "+rs.getString("email"));
                t1.append("\n    Phone Number:  "+rs.getString("phone"));
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
            }
            
            rs = c.s.executeQuery("SELECT * FROM meter_info WHERE meter_number = " + meter);
            
            if(rs.next()){
                t1.append("\n    Meter Location: "+rs.getString("meter_location"));
                t1.append("\n    Meter Type:     "+rs.getString("meter_type"));
                t1.append("\n    Phase Code:     "+rs.getString("phase_code"));
                t1.append("\n    Bill Type:      "+rs.getString("bill_type"));
                t1.append("\n    Days:           "+rs.getString("days"));
                t1.append("\n");
            }
            rs = c.s.executeQuery("SELECT * FROM tax_c");
            if(rs.next()){
                t1.append("---------------------------------------------------------------");
                t1.append("\n\n");
                t1.append("\n Cost per Unit:    Rs "+rs.getInt("cost_per_unit"));
                t1.append("\n Meter Rent:       Rs "+rs.getInt("meter_rent"));
                t1.append("\n Service Charge:   Rs "+rs.getInt("service_charge"));
                t1.append("\n Minimum Charge:   Rs "+rs.getInt("minimum_charge"));
                t1.append("\n Demand Charge:    Rs "+rs.getInt("demand_charge"));
                t1.append("\n Vat:              Rs "+rs.getInt("vat"));
                t1.append("\n");
                
            }
            
            rs = c.s.executeQuery("SELECT * FROM bill_c WHERE meter_number ="+meter+" AND month = '"+c2.getSelectedItem()+"'");
            
            if(rs.next()){
                t1.append("\n    Current Month :\t"+rs.getString("month"));
                t1.append("\n    Units Consumed:\t"+rs.getString("units"));
                t1.append("\n    Total Charges :\t"+rs.getInt("total_bill"));
                t1.append("\n---------------------------------------------------------------");
                t1.append("\n    TOTAL PAYABLE :\t"+rs.getInt("total_bill"));
            }
            
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new GenerateBill("").setVisible(true);
	}

}
