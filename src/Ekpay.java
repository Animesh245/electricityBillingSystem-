import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URI;


public class Ekpay extends JFrame implements ActionListener{

    String meter;
    JButton b1;
	
	Ekpay(String meter){
        this.meter = meter;
//        JEditorPane j = new JEditorPane();
//        j.setEditable(false);
//        
//        try {
//            j.setPage("https://ekpay.gov.bd/#/payment/electricity-bill");
//        }catch (IOException e) {
//            j.setContentType("text/html");
//            j.setText("<html>Could not load</html>");
//        }   
//        
//        
//        b1 = new JButton("Back");
//        b1.setBackground(Color.BLACK);
//        b1.setForeground(Color.WHITE);
//        b1.setBounds(500, 20, 120, 25);
//        b1.addActionListener(this);
//        j.add(b1);
        
		Runtime rt = Runtime.getRuntime();
		String url = "https://ekpay.gov.bd/#/payment/electricity-bill";
		try {
			rt.exec("rundll32 url.dll, FileProtocolHandler "+ url);		

			}
		catch(IOException e) {
			e.printStackTrace();
		}
        
     
        
//		JScrollPane scrollPane = new JScrollPane(j);     
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getContentPane().add(scrollPane);
//        setPreferredSize(new Dimension(800,600));
        
        setSize(800,800);
        setLocation(250,120);
//        setVisible(true);
	}
	
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new PayBill(meter).setVisible(true);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		new Ekpay("");
		
	}
}
