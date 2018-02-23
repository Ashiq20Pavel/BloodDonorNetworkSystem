/**
 	This is page where user's last updated post is shown!
 	
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

public class RecentPost extends JFrame implements ActionListener{
	
	
	JLabel l0= new JLabel("Post");
	JLabel l1= new JLabel("Name:");
	JLabel l2= new JLabel("BloodGroup:");
	JLabel l3= new JLabel("Area:");
	JLabel l4= new JLabel("Contact No: ");
	JLabel l5= new JLabel("Emergency:");
	JLabel l6= new JLabel("PostDate&Time:");
	JLabel l7=new JLabel("(Choose only Dhaka/Chittagong/Sylhet)");
	
	
	
	String [] bloodGroups= new String [] {"---","A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"};
	String [] eGroups=new String [] {"---","Yes","No"};
	
	JTextField f1 = new JTextField();
	JTextField f2 = new JTextField();
	JTextField f3 = new JTextField();
	JTextField f4 = new JTextField();
	JTextField f5 = new JTextField();
	JTextField f6 = new JTextField(); 
	
	
	JComboBox<String> eGroupList= new JComboBox<>(eGroups);
	JComboBox<String> bloodGroupList= new JComboBox<>(bloodGroups);
	
	JButton r1=new JButton("Cancel");
	JButton r2=new JButton("Post");
	JButton r3=new JButton("Edit");
	JButton r4=new JButton("Delete");
	
	String n,ar,co,bg,em,pt;
	String u;
	
	
	public RecentPost(String u)
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
		this.setTitle("Recent Post");
		
		l0.setBounds(325,200,100,30);
		l0.setForeground(new Color(253,254,254));
		add(l0);
		setLayout(null);
		
		
		l1.setBounds(200,250,150,30);
		l1.setForeground(new Color(253,254,254));
		add(l1);
		
		
		
		l2.setBounds(200,300,150,30);
		l2.setForeground(new Color(253,254,254));
		add(l2);
	
		
		
		l3.setBounds(200,350,150,30);
		l3.setForeground(new Color(253,254,254));
		add(l3);
		
		
		
		l4.setBounds(200,400,150,30);
		l4.setForeground(new Color(253,254,254));
		add(l4);
		
		l6.setBounds(190,470,150,30);
		l6.setForeground(new Color(253,254,254));
		add(l6);
		
		l5.setBounds(200,520,150,30);
		l5.setForeground(new Color(253,254,254));
		add(l5);
		
		
		add(f1);
		f1.setBounds(280,250,150,28);
	    f1.setBackground(Color.lightGray);
	    f1.setEditable(false);
		
	    add(f2);
		f2.setBounds(280,300,50,28);
	    f2.setBackground(Color.lightGray);
	    f2.setEditable(false);
		
		
		add(f3);
		f3.setBounds(280,350,150,28);
		f3.setBackground(Color.lightGray);
		f3.setEditable(false);
		
		add(f4);
		f4.setBounds(280,400,150,28);
		f4.setBackground(Color.lightGray);
		f4.setEditable(false);
		
		add(f5);
		f5.setBounds(280,520,50,28);
		f5.setBackground(Color.lightGray);
		f5.setEditable(false);
		
		add(f6);
		f6.setBounds(290,470,140,28);
		f6.setBackground(Color.lightGray);
		f6.setEditable(false);
		
		add(l7);
		l7.setBounds(445,350,250,30);
		
		add(bloodGroupList);
		bloodGroupList.setBounds(280,300,50,28);
		//bloodGroupList.setForeground(new Color(253,254,254));
		
		add(eGroupList);
		eGroupList.setBounds(280,520,50,28);
		
		
		add(r1);
		r1.setBounds(360,570,80,30);
		//r1.setForeground(new Color(253,254,254));
		
		add(r2);
		r2.setBounds(270,570,80,30);
		r2.setVisible(false);
		
		add(r3);
		r3.setBounds(270,570,80,30);
		//r2.setForeground(new Color(253,254,254));
		
		r4.setBounds(180,570,80,30);
		add(r4);
		setLayout(null);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		
		
		
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
		
		   else if (a.getSource()==r3)
		   {
			   //f1.setEditable(true); 
			   f2.setVisible(false);
			   f3.setEditable(true);
			   f4.setEditable(true);
			   f5.setVisible(false);
			   //f6.setEditable(true);
			   r2.setVisible(true);
			   r3.setVisible(false);
			   r4.setVisible(false);
			   eGroupList.setVisible(true);
			   bloodGroupList.setVisible(true);
			   
			   if(ar.length()==0 || co.length()==0 || bg.equals("---") || em.equals("---"))
			   {
				   JOptionPane.showMessageDialog(null,"Empty Field!");
			   }
			   
			   else{
			   
			   try
	            {
	                String query = "SELECT now() from dual";
	                Connection c = DatabaseConnection.dbConnector();
	                Statement st = c.createStatement();
	                ResultSet r = st.executeQuery(query);
	                
	                while(r.next())
	                {
	                    f6.setText(r.getString("now()"));
	                    System.out.println("Curent date working");
	                    
	                }
	            }
	            catch(Exception e)
	            {
	                System.out.println("Current date not working");
	                JOptionPane.showMessageDialog(null,e);
	            } 
		   }
		   }
			
		   else if (a.getSource()==r2)
			   { 
				   try
				   {
					   String query= "update blood3 set `Area` = "+'"'+ar+'"'+','+"`B_Group`="+'"'+bg+'"'+','+"`Text_Box` = "+'"'+co+'"'+','+"`Emergency`="+'"'+em+'"'+','+"`PostT&D`="+'"'+pt+'"'+" where user_name= "+'"'+n+'"';
					   Connection c = DatabaseConnection.dbConnector();
					   Statement st = c.createStatement();
					   st.executeUpdate(query);
					   
					   int count =0;
					   
						if(c!=null)
							{
								System.out.println(ar + " " + bg + " " + em + " " + co + " "+ pt + " ");
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
				   
			   }
		
		   else if (a.getSource()==r4){
			   
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
							Home h = new Home("");
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
