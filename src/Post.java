/**
 	This is page where user can give post!
 	
 	@author team Blood_Donor_Network_System
 	@version 2.6
 	@see java.lang.object
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.*;

public class Post extends JFrame implements ActionListener{
	
	
	JLabel l0= new JLabel("Post");
	JLabel l1= new JLabel("Name:");
	JLabel l2= new JLabel("BloodGroup:");
	JLabel l3= new JLabel("Wanted Area:");
	JLabel l4= new JLabel("Contact No:");
	JLabel l5= new JLabel("Emergency:");
	JLabel l6= new JLabel("PostDate&Time:");
	JLabel l7=new JLabel("(Choose only Dhaka/Chittagong/Sylhet)");
	
	
	
	String [] bloodGroups= new String [] {"---","A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"};
	String [] eGroups=new String [] {"---","Yes","No"};
	
	JTextField f1 = new JTextField();
	JTextField f3 = new JTextField();
	JTextField f4 = new JTextField();
	JTextField f6 = new JTextField(); 
	
	
	JComboBox<String> eGroupList= new JComboBox<>(eGroups);
	JComboBox<String> bloodGroupList= new JComboBox<>(bloodGroups);
	
	JButton r1=new JButton("Cancel");
	JButton r2=new JButton("Post");
	
	String n,ar,co,bg,em,pt;
	String u;
	
	
	public Post(String u)
	{
		this.u=u;
        System.out.print(this.u);
		
		setSize(700,730);
		setBackground(Color.red);
		this.setContentPane(new JLabel(new ImageIcon("Blood3.jpg")));
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setTitle("Post");
		
		l0.setBounds(325,200,100,30);
		l0.setForeground(new Color(253,254,254));
		add(l0);
		setLayout(null);
		
		
		l1.setBounds(190,250,150,30);
		l1.setForeground(new Color(253,254,254));
		add(l1);
		
		
		
		l2.setBounds(190,300,150,30);
		l2.setForeground(new Color(253,254,254));
		add(l2);
	
		
		
		l3.setBounds(190,350,150,30);
		l3.setForeground(new Color(253,254,254));
		add(l3);
		
		
		
		l4.setBounds(190,400,150,30);
		l4.setForeground(new Color(253,254,254));
		add(l4);
		
		l6.setBounds(190,470,150,30);
		l6.setForeground(new Color(253,254,254));
		add(l6);
		
		l5.setBounds(190,520,150,30);
		l5.setForeground(new Color(253,254,254));
		add(l5);
		
		
		add(f1);
		f1.setBounds(280,250,150,28);
	    f1.setBackground(Color.lightGray);
	    f1.setEditable(false);
		
		
		
		
		add(f3);
		f3.setBounds(280,350,150,28);
		f3.setBackground(Color.lightGray);
		
		add(f4);
		f4.setBounds(280,400,150,28);
		f4.setBackground(Color.lightGray);
		
		add(f6);
		f6.setBounds(290,470,140,28);
		f6.setBackground(Color.lightGray);
		f6.setEditable(false);
		
		add(l7);
		l7.setBounds(445,470,250,30);
		
		add(bloodGroupList);
		bloodGroupList.setBounds(280,300,50,28);
		//bloodGroupList.setForeground(new Color(253,254,254));
		
		add(eGroupList);
		eGroupList.setBounds(280,520,50,28);
		
		
		add(r1);
		r1.setBounds(210,570,100,30);
		//r1.setForeground(new Color(253,254,254));
		
		add(r2);
		r2.setBounds(350,570,80,30);
		//r2.setForeground(new Color(253,254,254));
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		r1.addActionListener(this);
		
		r2.addActionListener(this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	
	{
		n = this.u;
		ar = f3.getText();
		co=  f4.getText();
		bg=String.valueOf(bloodGroupList.getSelectedItem());
		em=String.valueOf(eGroupList.getSelectedItem());
		pt=f6.getText();
		
		if(a.getSource()==r1)
		
		   {
		       Home h=new Home(this.u);
			   setVisible(false);
		   }
		
		   else if (a.getSource()==r2)
		   { 
			   if(ar.length()==0 || co.length()==0 || bg.equals("---") || em.equals("---"))
			   {
				   JOptionPane.showMessageDialog(null,"Empty Field!");
			   }
			   
			   else{
			   try
			   {
				   String query= "update blood3 set `Area` = "+'"'+ar+'"'+','+"`B_Group`="+'"'+bg+'"'+','+"`Text_Box` = "+'"'+co+'"'+','+"`Emergency`="+'"'+em+'"'+','+"`PostT&D`="+'"'+pt+'"'+" where user_name= "+'"'+n+'"';
				   Connection c = DatabaseConnection.dbConnector();
				   Statement st = c.createStatement();
				   st.executeUpdate(query);
				   
				   int count =0;
				   
					if(c!=null)
						{
							System.out.println(ar + " " + bg + " " + em + " " + c + " "+ pt + " ");
							JOptionPane.showMessageDialog(null,"Post Successful!");
							Home h = new Home(this.u);
							dispose();
							
						}
					else if(c == null)
						{
							System.out.println(n+" "+ar+" "+co+" ");
							JOptionPane.showMessageDialog(null,"Error!");
						}
					
					c.close();
			  }
			   
			   catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
					System.out.println("reg");
				}
			   
			   //JOptionPane.showMessageDialog(this,"Posted!");
			   //Home h = new Home();
			  // this.setVisible(false);
		   }
	
	
}
}
}