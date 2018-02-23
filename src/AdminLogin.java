/**
 	This is Admin's Login Page!
 	
 	@author team Blood_Donor_Network_System
 	@version 2.6
 	@see java.lang.object
 */

import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//import java.sql.SQLException;
//import com.mysql.jdbc.*;
	
public class AdminLogin extends JFrame implements ActionListener{
	
	
	JButton b2=new JButton("Login");
	JButton b1=new JButton("Back");
	JTextField d1=new JTextField();
	JPasswordField d2=new JPasswordField(10);
	JLabel l1=new JLabel("Admin:");
	JLabel l2=new JLabel("Password:");
	JLabel l3=new JLabel("Admin Login");
	
	Connection connection = null;
	String u;
	char [] p;
	
	
	public AdminLogin(){
		setSize(700,730);
		setBackground(Color.red);
		this.setContentPane(new JLabel(new ImageIcon("Blood3.jpg")));
		setVisible(true);
		this.setTitle("Blood Donor Network System");
		setLocationRelativeTo(null);
		setResizable(false);
		
		l3.setBounds(322,220,100,30);
		l3.setForeground(new Color(253,254,254));
		add(l3);
		setLayout(null);
		
		
		l1.setBounds(200,320,80,20);
		l1.setForeground(new Color(253,254,254));
		add(l1);
		setLayout(null);

		d1.setBounds(280,320,150,20);
		d1.setBackground(Color.white);
		add(d1);

		l2.setBounds(200,370,80,20);
		l2.setForeground(new Color(253,254,254));
		add(l2);
		setLayout(null);

		d2.setBounds(280,370,150,20);
		d2.setBackground(Color.white);
		add(d2);

		
		b1.setBounds(230,450,100,30);
		b1.setBackground(new Color(253,254,254));
		add(b1);
		setLayout(null);

		b2.setBounds(360,450,80,30);
		b2.setBackground(new Color(253,254,254));
		add(b2);
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b2.addActionListener(this);
		
		b1.addActionListener(this);
		

	}
	
public void actionPerformed(ActionEvent a)
{
	u = d1.getText();
	p = d2.getPassword();
		if(a.getSource()==b2)
		{	
				try
				{
					
					String query ="Select * from admin where ad_Name = "+"'"+u+"'"+" and ad_Pass = "+"'"+new String(p)+"'";
					Connection c = DatabaseConnection.dbConnector();
					Statement st = c.createStatement();
					ResultSet r = st.executeQuery(query);

					int count =0;
					while(r.next())
						{
							count=count+1;
						}
					if(count>=1)
						{
							System.out.println(u+" "+new String(p));
							JOptionPane.showMessageDialog(null,"Login Successfully");
							AdminPage ap = new AdminPage();
							dispose();
							
						}
					else
						{
							System.out.println(u+" "+new String(p));
							JOptionPane.showMessageDialog(null,"Username or Password is incorrect!");
						}
					
					r.close();
				}
					
					catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
							System.out.println("E2");
						}
						
		}
		
		else if (a.getSource()==b1){
			
			Login l= new Login();
			this.setVisible(false);
			}
		
		
}
}