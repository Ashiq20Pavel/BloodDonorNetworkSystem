/**
 	This is Admin's Operation Page!
 	
 	@author team Blood_Donor_Network_System
 	@version 2.6
 	@see java.lang.object
 */

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AdminPage extends JFrame implements ActionListener
{
	JButton r1=new JButton("Delete Post");
	JButton r2=new JButton("Delete ID");
	JLabel l1=new JLabel("UserName:");
	JTextField d1=new JTextField();
	String u;
	
	public AdminPage(){
		setSize(700,730);
		setBackground(Color.red);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setTitle("Admin");
		
		this.setContentPane(new JLabel(new ImageIcon("Blood3.jpg")));
		
		l1.setBounds(250,120,80,20);
		l1.setForeground(new Color(253,254,254));
		add(l1);
		setLayout(null);
		
		d1.setBounds(340,120,120,20);
		d1.setBackground(Color.white);
		add(d1);
		
		add(r1);
		r1.setBounds(250,150,100,28);
		r1.setBackground(new Color(204, 209, 209));
		
		add(r2);
		r2.setBounds(370,150,100,28);
		r2.setBackground(new Color(204, 209, 209));
		
		//r1.addActionistener(this);
		
		setLayout(null);
		
		r2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
public void actionPerformed(ActionEvent a)
	
	{
		//n = this.u;
		//ar = f3.getText();
		//t=  f4.getText();
		//bg=String.valueOf(bloodGroupList.getSelectedItem());
		//em=String.valueOf(eGroupList.getSelectedItem());
		//pt=f6.getText();
	      u=d1.getText();
		
		
		   if (a.getSource()==r2)
		   { 
			   try
			   {
				   String query= "DELETE FROM `blood3` WHERE user_Name ="+'"'+u+'"';
				   Connection c = DatabaseConnection.dbConnector();
				   Statement st = c.createStatement();
				   st.executeUpdate(query);
				   
				   int count =0;
				   
					
				  
				   
					if(c!=null)
						{
							System.out.println(u + " " );
							JOptionPane.showMessageDialog(null,"Delete Successful!");
							AdminPage ap = new AdminPage();
							dispose();
					
					         c.close();
						}
			   }
			  
			   catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
					System.out.println("reg");
				}
		   }
			   
			 

}
}



