/**
 	This is Login Page!
 	
 	@author team Blood_Donor_Network_System
 	@version 2.6
 	@see java.lang.object
 */

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import com.mysql.jdbc.*;
//import javax.swing.table.DefaultTableModel;
	
public class Login extends JFrame implements ActionListener{
	
	
	JButton b2=new JButton("Login");
	JButton b1=new JButton("Register");
	JButton b3=new JButton("Admin");
	JButton b4=new JButton("Forget Password");
	JTextField d1=new JTextField();
	JPasswordField d2=new JPasswordField(5);
	JLabel l1=new JLabel("UserName:");
	JLabel l2=new JLabel("Password:");
	JLabel l3=new JLabel("Login");
	
	JLabel txtHomeInfo = new JLabel("BLOOD DONOR NETWORK SYSTEM");
	
	
	
	
	Connection connection = null;
	static String u;
	char [] p;
	
	JLabel label;
	ImageIcon image;
	
	
	public Login(){
		
		
		setSize(700,730);
		setBackground(Color.red);
		setVisible(true);
		this.setTitle("Blood Donor Network System");
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		image = new ImageIcon(getClass().getResource("blood1.jpg"));
        label = new JLabel(image);
        
        txtHomeInfo.setForeground(new Color(253,254,254));
        txtHomeInfo.setFont(new Font("Impact", Font.BOLD, 30));
        txtHomeInfo.setBounds(120,120,500,50);
        add(txtHomeInfo);
		
		l3.setBounds(322,220,100,30);
		l3.setForeground(new Color(253,254,254));
		add(l3);
		
		
		l1.setBounds(200,320,80,20);
		l1.setForeground(new Color(253,254,254));
		add(l1);

		d1.setBounds(280,320,150,20);
		d1.setBackground(Color.white);
		add(d1);

		l2.setBounds(200,370,80,20);
		l2.setForeground(new Color(253,254,254));
		add(l2);

		d2.setBounds(280,370,150,20);
		d2.setBackground(Color.white);
		add(d2);
		
		
		b1.setBounds(230,450,100,30);
		b1.setBackground(new Color(253,254,254));
		add(b1);
		

		b2.setBounds(360,450,80,30);
		b2.setBackground(new Color(253,254,254));
		add(b2);
		
		
		b3.setBounds(300,490,80,30);
		b3.setBackground(new Color(253,254,254));
		add(b3);
		
		
		b4.setBounds(280,410,135,28);
		b4.setBackground(new Color(253,254,254));
		add(b4);
		
		
		add(label);
        pack();
        
        setLayout(null);
		
        
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b2.addActionListener(this);
		
		b1.addActionListener(this);
		
		b3.addActionListener(this);
		
		b4.addActionListener(this);

	}
	
	
	
	
public void actionPerformed(ActionEvent a)
{
	u = d1.getText();
	p = d2.getPassword();
		if(a.getSource()==b2)
		{	
				try
				{
					
					String query ="Select * from blood2 where User_Name = "+"'"+u+"'"+" and Password = "+"'"+new String(p)+"'";
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
							Home h=new Home(u);
							
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
				Registration f = new Registration();
				this.setVisible(false);
			}
		
		else if (a.getSource()==b3){
				
				AdminLogin al = new AdminLogin();
				this.setVisible(false);
		}
		
		else if (a.getSource()==b4){
			Verification v = new Verification (null);
			this.setVisible(false);
		}
}



		
}
