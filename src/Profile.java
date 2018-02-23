/**
 	This is Profile Page!
 	
 	@author team Blood_Donor_Network_System
 	@version 2.6
 	@see java.lang.object
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;

public class Profile extends JFrame implements ActionListener{
	
	{Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setBounds(0,0,screenSize.width, screenSize.height);
      setVisible(true);

	pack();}

	JLabel l0=new JLabel("Profile");
	JLabel l1= new JLabel("First Name: ");
	JLabel l2= new JLabel("Last Name: ");
	JLabel l3= new JLabel("Username: ");
	JLabel l4= new JLabel("E-mail: ");
	JLabel l5= new JLabel("Area: ");
	JLabel l6= new JLabel("Contact No: ");
	JLabel l7= new JLabel("Blood Group: ");
	JLabel l11= new JLabel("Gender: ");
	JLabel l12=new JLabel("(Choose only Dhaka/Chittagong/Sylhet)");
	
	
	JTextField f1 = new JTextField();
	JTextField f2 = new JTextField();
	JTextField f3 = new JTextField();
	JTextField f4 = new JTextField();
	JTextField f5 = new JTextField();
	JTextField f6 = new JTextField();
	JTextField f7 = new JTextField();
	JTextField f11 = new JTextField();
	
	String [] genderGroups= new String [] {"---","Male", "Female"};
	JComboBox<String> genderGroupList= new JComboBox<>(genderGroups);
	
	String [] bloodGroups= new String [] {"---","A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"};
	JComboBox<String> bloodGroupList= new JComboBox<>(bloodGroups);
	
	JButton p1=new JButton("Edit");
	JButton p2=new JButton("Back");
	JButton p3=new JButton("Save");
	
	String fn,ln,u,e,ad,cn,bg,gg;
	String n;
	
	
	
	public Profile(String u)
	{
		this.u=u;
        System.out.print(this.u);
        
		setSize(700,730);
		setBackground(Color.red);
		this.setContentPane(new JLabel(new ImageIcon("Blood3.jpg")));
		setVisible(true);
		this.setTitle("Profile");
		
		l0.setBounds(300,30,100,30);
		l0.setForeground(new Color(245,222,179));
		add(l0);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(l1);
		l1.setBounds(100,90,150,30);
		l1.setForeground(new Color(253,254,254));
		add(l2);
		l2.setBounds(100,140,150,30);
		l2.setForeground(new Color(253,254,254));
		add(l3);
		l3.setBounds(100,190,150,30);
		l3.setForeground(new Color(253,254,254));
		add(l4);
		l4.setBounds(100,240,150,30);
		l4.setForeground(new Color(253,254,254));
		add(l5);
		l5.setBounds(100,290,150,30);
		l5.setForeground(new Color(253,254,254));
		add(l6);
		l6.setBounds(100,340,150,30);
		l6.setForeground(new Color(253,254,254));
		add(l7);
		l7.setBounds(100,390,150,30);
		l7.setForeground(new Color(253,254,254));
		add(l11);
		l11.setBounds(100,440,150,30);
		l11.setForeground(new Color(253,254,254));
		
				
		add(f1);
		f1.setBounds(250,90,150,28);
		f1.setBackground(Color.lightGray);
		//f1.setVisible(false);
		f1.setEditable(false);
		add(f2);
		f2.setBounds(250,140,150,28);
		f2.setBackground(Color.lightGray);
		//f2.setVisible(false);
		f2.setEditable(false);
		add(f3);
		f3.setBounds(250,190,150,28);
		f3.setBackground(Color.lightGray);
		//f3.setVisible(false);
		f3.setEditable(false);
		add(f4);
		f4.setBounds(250,240,150,28);
		f4.setBackground(Color.lightGray);
		//f4.setVisible(false);
		f4.setEditable(false);
		add(f5);
		f5.setBounds(250,290,150,28);
		f5.setBackground(Color.lightGray);
		//f5.setVisible(false);
		f5.setEditable(false);
		add(f6);
		f6.setBounds(250,340,150,28);
		f6.setBackground(Color.lightGray);
		//f6.setVisible(false);
		f6.setEditable(false);
		add(f7);
		f7.setBounds(250,390,150,28);
		f7.setBackground(Color.lightGray);
		//f7.setVisible(false);
		f7.setEditable(false);
		add(f11);
		f11.setBounds(250,440,150,28);
		f11.setBackground(Color.lightGray);
		f11.setEditable(false);
		
		add(l12);
		l12.setBounds(410,290,250,30);
	
		add(p1);
		p1.setBounds(200,490,85,28);
		
		add(p2);
		p2.setBounds(315,490,85,28);
		
		add(p3);
		p3.setBounds(315,490,85,28);
		
		add(genderGroupList);
		genderGroupList.setBounds(250,440,150,28);
		genderGroupList.setBackground(new Color(253,254,254));
		
		add(bloodGroupList);
		bloodGroupList.setBounds(250,390,150,28);
		bloodGroupList.setBackground(new Color(253,254,254));
		
		
		setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		p2.addActionListener(this);
		p1.addActionListener(this);
		p3.addActionListener(this);
		
		//this.u=u;
		
		
	}
	
		public void actionPerformed(ActionEvent a)
		{
			n = this.u;
			fn = f1.getText();
			ln = f2.getText();
			u = f3.getText();
			e = f4.getText();
			ad = f5.getText();
			cn = f6.getText();
			gg=String.valueOf(genderGroupList.getSelectedItem());
			bg = String.valueOf(bloodGroupList.getSelectedItem());
			
			
			/*t=  f4.getText();
			bg=String.valueOf(bloodGroupList.getSelectedItem());
			em=String.valueOf(eGroupList.getSelectedItem());
			pt=f6.getText();*/
			
		 if(a.getSource()==p1)
		 {
			 
			//f1.setVisible(true);
			 f1.setEditable(true);			 
			 f2.setEditable(true);
			 f3.setEditable(true);
			 f4.setEditable(true);
			 f5.setEditable(true);
			 f6.setEditable(true);
			 f7.setVisible(false);
			 f11.setVisible(false);
			 p2.setVisible(false);
			 p3.setVisible(true);
			 genderGroupList.setVisible(true);
			 bloodGroupList.setVisible(true);
			 
		    }
			 else if(a.getSource()==p2)
			 {
				 Home h = new Home(this.u);
				 setVisible(false);
			 }
			 
			 else if(a.getSource()==p3)
			 {
				 String ss = f3.getText();
				 
				 if(fn.length()==0 || ln.length()==0 || u.length()==0 || e.length()==0 || ad.length()==0 || cn.length()==0 || gg.equals("---") || bg.equals("---"))
				 {
					 JOptionPane.showMessageDialog(null,"Empty Field!");
				 }
				 
				 else
				 {
				 
					 try
					   {
						   String query= "update blood2 set `First_Name` = "+'"'+fn+'"'+','+"`Last_Name`="+'"'+ln+'"'+','+"`User_Name` = "+'"'+u+'"'+','+"`Email`="+'"'+e+'"'+','+"`Address`="+'"'+ad+'"'+','+"`Contact_No`="+'"'+cn+'"'+','+"`Gender`="+'"'+gg+'"'+','+"`B_Group`="+'"'+bg+'"'+" where user_name= "+'"'+n+'"';
						   Connection c = DatabaseConnection.dbConnector();
						   Statement st = c.createStatement();
						   st.executeUpdate(query);
						   
						   int count =0;
						   
							if(c!=null)
								{
									System.out.println(fn + " " + ln + " " + u + " " + e  + " " + ad  + " " + cn  + " " + gg + " "+ bg + " ");
									JOptionPane.showMessageDialog(null,"Save Successful!");
									Home h = new Home(this.u);
									dispose();
									
								}
							else if(c == null)
								{
								    System.out.println(fn + " " + ln + " " + u + " " + e  + " " + ad  + " " + cn  + " " + gg + " "+ bg + " ");
									JOptionPane.showMessageDialog(null,"Error!");
								}
							
							c.close();
					  }
					   
					   catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
							System.out.println("working");
						}
				 
				 try
				   {
					   
					  String query= "update blood3 set `User_Name`= "+'"'+ss+'"'+" where user_name= "+'"'+n+'"';
					   Connection c = DatabaseConnection.dbConnector();
					   Statement st = c.createStatement();
					   st.executeUpdate(query);
					   
					   System.out.println("working 1"+ss+" "+n);
				   }
				   catch(Exception e)
				   {
					   System.out.println("Exception working");
				   }
				 
				 
				 
				 }
			 }
		
	}
}
	
	
	
