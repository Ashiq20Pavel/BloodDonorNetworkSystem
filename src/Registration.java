/**
 	This is Registration Page!
 	
 	@author team Blood_Donor_Network_System
 	@version 2.6
 	@see java.lang.object
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class Registration extends JFrame implements ActionListener{
	
	
	
	JLabel l1= new JLabel("First Name:");
	JLabel l2= new JLabel("Last Name:");
	JLabel l3= new JLabel("Username:");
	JLabel l4= new JLabel("Password:");
	JLabel l5= new JLabel("Confirm Password:");
	JLabel l6= new JLabel("E-mail:");
	JLabel l7= new JLabel("Contact No:");
	JLabel l8= new JLabel("Blood Group:");
	JLabel l9= new JLabel("Gender: ");
	JLabel l0=new JLabel("Registration");
	JLabel l11=new JLabel("Area: ");
	JLabel l12=new JLabel("(Choose only Dhaka/Chittagong/Sylhet)");
	
	String [] bloodGroups= new String [] {"---","A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"};
	
	String [] genderGroups= new String [] {"---","Male", "Female"};
	
	
	JTextField f1 = new JTextField();
	JTextField f2 = new JTextField();
	JTextField f3 = new JTextField();
	JPasswordField f4 = new JPasswordField(10);
	JPasswordField f5 = new JPasswordField(10);
	JTextField f6 = new JTextField();
	JTextField f7 = new JTextField();
	JTextField f8 = new JTextField();
	JTextField f11 = new JTextField();
	
	//JRadioButton option1= new JRadioButton("Male");
	//JRadioButton option2= new JRadioButton("Female");
	
	JComboBox<String> bloodGroupList= new JComboBox<>(bloodGroups);
	JComboBox<String> genderGroupList= new JComboBox<>(genderGroups);
	
	//ButtonGroup group= new ButtonGroup();
	
	JButton r1=new JButton("Cancel");
	JButton r2=new JButton("Submit");
	
	String f, l, u, e, c,ad, g1,bg,gg;
	//int bg;
	String p,cp;
	//char [] cp;
	
	
	public Registration(){
		setSize(700,730);
		setBackground(Color.red);
		this.setContentPane(new JLabel(new ImageIcon("Blood3.jpg")));
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setTitle("Registration");
		
		l0.setBounds(300,30,100,30);
		l0.setForeground(new Color(253,254,254));
		add(l0);
		setLayout(null);
		
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
		
		add(l11);
		l11.setBounds(100,390,150,30);
		l11.setForeground(new Color(253,254,254));
		
		add(l7);
		l7.setBounds(100,440,150,30);
		l7.setForeground(new Color(253,254,254));
		
		add(l8);
		l8.setBounds(100,490,150,30);
		l8.setForeground(new Color(253,254,254));
		
		add(l9);
		l9.setBounds(100,540,150,30);
		l9.setForeground(new Color(253,254,254));
		
				
		add(f1);
		f1.setBounds(250,90,150,28);
	    f1.setBackground(Color.lightGray);
		//f1.setForeground(Color.red);
		
		add(f2);
		f2.setBounds(250,140,150,28);
		f2.setBackground(Color.lightGray);
		
		add(f3);
		f3.setBounds(250,190,150,28);
		f3.setBackground(Color.lightGray);
		
		add(f4);
		f4.setBounds(250,240,150,28);
		f4.setBackground(Color.lightGray);
		
		add(f5);
		f5.setBounds(250,290,150,28);
		f5.setBackground(Color.lightGray);
		
		add(f6);
		f6.setBounds(250,340,150,28);
		f6.setBackground(Color.lightGray);
		
		add(f11);
		f11.setBounds(250,390,150,28);
		f11.setBackground(Color.lightGray);
		
		add(l12);
		l12.setBounds(410,390,250,30);
		
		add(f7);
		f7.setBounds(250,440,150,28);
		f7.setBackground(Color.lightGray);
		
		add(bloodGroupList);
		bloodGroupList.setBounds(250,490,50,28);
		bloodGroupList.setBackground(new Color(253,254,254));
		
		add(genderGroupList);
		genderGroupList.setBounds(250,540,70,28);
		genderGroupList.setBackground(new Color(253,254,254));
		
		
		/*group.add(option1);
		group.add(option2);
		
		add(option1);
		option1.setBounds(250,490,70,28);
		option1.setBackground(new Color(204, 209, 209));
		
		add(option2);
		option2.setBounds(320,490,90,28);
		option2.setBackground(new Color(204, 209, 209));*/
	
		add(r1);
		r1.setBounds(200,590,85,28);
		r1.setBackground(new Color(204, 209, 209));
		
		add(r2);
		r2.setBounds(315,590,85,28);
		r2.setBackground(new Color(204, 209, 209));
		
		setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		r1.addActionListener(this);
		r2.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
		
		f = f1.getText();
		l = f2.getText();
		u = f3.getText();
		p = new String(f4.getPassword());
		cp =new String(f5.getPassword()); 
		e = f6.getText();
		c = new String (f7.getText());
		ad = f11.getText();
		gg=String.valueOf(genderGroupList.getSelectedItem());
		bg = String.valueOf(bloodGroupList.getSelectedItem());
		//rb =group.getText();
		//rb = String.valueOf(option1.getIcon());
		
		
		
		if(a.getSource()==r1)
		   {
		       Login l=new Login();
			   this.setVisible(false);
		   }

		   else if(a.getSource()==r2)
		   {
			  
			   if(!(p.equals(cp)) || (f.length()==0 || l.length()==0 || u.length()==0 || p.length()==0 || cp.length()==0 || e.length()==0 || c.length()==0 || ad.length()==0 || bg.equals("---") || gg.equals("---")))
			   {
				   if(!(p.equals(cp))){
					   JOptionPane.showMessageDialog(null,"Password Doesn't Match"); 
				   }
		
				   
				   else
				   {
					   JOptionPane.showMessageDialog(null,"Empty Field!");
				   }
			   }
			   
			   
			   
			   else {
				   
				   try
				   {
					   String query = "INSERT INTO `blood2`(`First_Name`, `Last_Name`, `User_Name`, `Password`, `Confirm_Password`, `Email`,`Address`, `Contact_No`,`B_Group`,`Gender`) VALUES ("+'"'+f+'"'+','+'"'+l+'"'+','+'"'+u+'"'+','+'"'+new String(p)+'"'+','+'"'+new String(cp)+'"'+','+'"'+e+'"'+','+'"'+ad+'"'+','+'"'+c+'"'+','+'"'+bg+'"'+','+'"'+gg+'"'+')';
					   Connection c = DatabaseConnection.dbConnector();
					   Statement st = c.createStatement();
					   st.executeUpdate(query);
					   
					   int count =0;
					   
						if(c!=null)
							{
								System.out.println(f + " " + l + " " + u + " " +new String(p) +" " +new String(cp) +" " + e + " "+ ad +" " + c + " " + g1 + " "+ bg + " " + gg + " ");
								JOptionPane.showMessageDialog(null,"Registration Successful!");
								Login l = new Login();
								dispose();
								
							}
						/*else if(c==null)
							{
								System.out.println(f+" "+l+" "+u+" "+new String(p)+" "+new String(cp)+" "+e+" "+c+" "+g1+" "+bg+" "+rb+" ");
								JOptionPane.showMessageDialog(null,"Error!");
								dispose();
							}*/
						
						c.close();
				  }
				   
				   catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,e);
						System.out.println("reg");
					}
				   try
				   {
					   
					   String query = "INSERT INTO `blood3`(`User_Name`, `Area`, `Text_Box`,`B_Group`,`Emergency`,`PostT&D`) VALUES ("+'"'+u+'"'+','+'"'+null+'"'+','+'"'+null+'"'+','+'"'+null+'"'+','+'"'+null+'"'+','+'"'+null+'"'+')';
					   Connection c = DatabaseConnection.dbConnector();
					   Statement st = c.createStatement();
					   st.executeUpdate(query);
					   
					   System.out.println("working 1");
				   }
				   catch(Exception e)
				   {
					   System.out.println("Exception working");
				   }
				   
			   }
			   
			
		   }
		   
		   
	
	}
}