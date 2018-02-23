/**
 	This is Home Page!
 	
 	@author team Blood_Donor_Network_System
 	@version 2.6
 	@see java.lang.object
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame implements ActionListener
{
	
	JButton r1=new JButton("Post");
	JButton r2=new JButton("Recent Post");
	JButton r3=new JButton("Profile");
	JButton r4=new JButton("Refresh");
	JButton r5=new JButton("LogOut");
    
	String bGroup;
	String u;
	
/* For JTable */
	
	public ArrayList<String> notifPost = new ArrayList<String>();
	public ArrayList<String> notifUser = new ArrayList<String>();
	public ArrayList<String> Bg = new ArrayList<String>();
	public ArrayList<String> Area = new ArrayList<String>();
	public ArrayList<String> Date = new ArrayList<String>();

	DefaultTableModel tableModel = new DefaultTableModel(){
		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	
	public Home(String u)
	{
       
		this.u=u;
        System.out.print(this.u);
        
        this.setTitle("Home");
        
        DefaultTableModel dt = getData();
        
		JTable jt = new JTable(dt);
	
		
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane s = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(s, BorderLayout.CENTER);
		jp.setLocation(30, 200);
		jp.setSize(635,250);
		
		setSize(700,730);
		setBackground(Color.red);
		this.setContentPane(new JLabel(new ImageIcon("Blood3.jpg")));
		
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		add(jp, BorderLayout.CENTER);
		
		
		setLayout(null);
		
		
		
		r1.setBounds(290,150,120,30);
		r1.setBackground(new Color(253,254,254));
		add(r1);
		setLayout(null);

		r2.setBounds(545,150,120,30);
		r2.setBackground(new Color(253,254,254));
		add(r2);
		setLayout(null);
		
		r3.setBounds(30,150,120,30);
		r3.setBackground(new Color(253,254,254));
		add(r3);
		setLayout(null);
		
		r4.setBounds(545,30,120,30);
		r4.setBackground(new Color(253,254,254));
		add(r4);
		setLayout(null);
		
		r5.setBounds(545,500,120,30);
		r5.setBackground(new Color(253,254,254));
		add(r5);
		
        setLayout(null);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		r1.addActionListener(this);
		
		r2.addActionListener(this);
		
		r3.addActionListener(this);
		
		r4.addActionListener(this);
		
		r5.addActionListener(this);
		
		
		
	}
	
	public DefaultTableModel getData()
	{
		String query = "select * from blood3 where B_Group='"+getUserGroup()+"'"+" or Emergency = 'Yes'";
		String us, post,area,bg,dt;
		 
		 try {
			 Connection c = DatabaseConnection.dbConnector();
			 Statement st = c.createStatement();
			 ResultSet r = st.executeQuery(query);
			 
			 
			 while(r.next())
			 {
				 notifPost.add(r.getString("Text_Box"));
				 notifUser.add(r.getString("User_Name"));
				 Bg.add(r.getString("B_Group"));
				 Area.add(r.getString("Area"));
				 Date.add(r.getString("PostT&D"));
				 
			 }
			 
			 System.out.println("\n");
			 
			 JTable jt = new JTable(tableModel);
			 
			 tableModel.addColumn("User");
			 tableModel.addColumn("Blood Group");
			 tableModel.addColumn("Area");
			 tableModel.addColumn("Contact");
			 tableModel.addColumn("Date");
			 
			 for(int i=0; i<notifUser.size(); i++)
			 {
				 System.out.println(notifUser.get(i)+ " " + notifPost.get(i) + " " + Bg.get(i)+ " " + Area.get(i)+ " " + Date.get(i));
				 System.out.println();
				 
				 us = notifUser.get(i);
				 post = notifPost.get(i);
				 bg = Bg.get(i);
				 area = Area.get(i);
				 dt = Date.get(i);
				 
				 Object[] obj = {us, bg, area, post, dt};
				 
				 tableModel.addRow(obj);
				 
			 }
			 
			 return tableModel;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==r1)
		
		   {
			String u=this.u;
			Post f = new Post(this.u);
			//f.f1.setText(this.u);
			   try
			   {
				   String query = "select * from blood2,blood3 where blood2.user_name=blood3.user_name and blood2.user_name = "+'"'+u+'"';
				   
				   Connection c = DatabaseConnection.dbConnector();
				   Statement st = c.createStatement();
				   ResultSet r = st.executeQuery(query);
				   
				   while(r.next())
				   {
					   f.f1.setText(r.getString("User_Name"));
					   
					   dispose();
				   }
				   r.close();
			  }
			  catch(Exception e)
			   {
				   JOptionPane.showMessageDialog(null,e);
			   }
			   this.setVisible(false);
		       //Post f=new Post();
			   //this.setVisible(false);
			   try
	            {
	                String query = "SELECT now() from dual";
	                Connection c = DatabaseConnection.dbConnector();
	                Statement st = c.createStatement();
	                ResultSet r = st.executeQuery(query);
	                
	                while(r.next())
	                {
	                	
	                    f.f6.setText(r.getString("now()"));
	                    System.out.println("Curent date working");
	                    
	                }
	            }
	            catch(Exception e)
	            {
	                System.out.println("Current date not working");
	                JOptionPane.showMessageDialog(null,e);
	            }
			   
			   
			   
		   }
		
		
		   else if(a.getSource()==r2)
		   {
			   String u=this.u;
			   
			   RecentPost v=new RecentPost(this.u);
			   try
			   {
				   String query = "select * from Blood3 where user_name = "+'"'+u+'"';
				   
				   Connection c = DatabaseConnection.dbConnector();
				   Statement st = c.createStatement();
				   ResultSet r = st.executeQuery(query);
				   
				   while(r.next())
				   {
			
					   v.f1.setText(r.getString("User_Name"));
					   v.f2.setText(r.getString("B_Group"));
					   v.f3.setText(r.getString("Area"));
					   v.f4.setText(r.getString("Text_Box"));
					   v.f5.setText(r.getString("Emergency"));
					   v.f6.setText(r.getString("PostT&D"));
					   bGroup = r.getString("B_Group");
					   //p.f8.setText(r.getString("Doner Type"));
					   //p.f9.setText(r.getString("Area"));
					   //p.f10.setText(r.getString("Last_Time_Donated"));
					   //v.f11.setText(r.getString("Gender"));
					   dispose();
				   }
				   r.close();
			   }
			   catch(Exception e)
			   {
				   JOptionPane.showMessageDialog(null,e);
			   }
			   this.setVisible(false);
			   
			  // RecentPost v=new RecentPost(this.u);
			  // this.setVisible(false);
			 
		   }
		
		
		   else if (a.getSource()==r3)
		   {
			   String u=this.u;
			   Profile p=new Profile(u);
			   try
			   {
				   String query = "select * from Blood2 where user_name = "+'"'+u+'"';
				   
				   Connection c = DatabaseConnection.dbConnector();
				   Statement st = c.createStatement();
				   ResultSet r = st.executeQuery(query);
				   
				   while(r.next())
				   {
//					   bGroup = r.getString("B_Group");
					   p.f1.setText(r.getString("First_Name"));
					   p.f2.setText(r.getString("Last_Name"));
					   p.f3.setText(r.getString("User_Name"));
					   p.f4.setText(r.getString("Email"));
					   p.f5.setText(r.getString("Address"));
					   p.f6.setText(r.getString("Contact_No"));
					   p.f7.setText(r.getString("B_Group"));
					   //p.f8.setText(r.getString("Doner Type"));
					   //p.f9.setText(r.getString("Area"));
					   //p.f10.setText(r.getString("Last_Time_Donated"));
					   p.f11.setText(r.getString("Gender"));
					   dispose();
				   }
				   bGroup = p.f7.getText();
				   r.close();
			   }
			   catch(Exception e)
			   {
				   JOptionPane.showMessageDialog(null,e);
			   }
			   this.setVisible(false);
		   
		   }
		   else if(a.getSource()==r4)
		   {
			   this.dispose();
			   Home h = new Home("");
			   
		   }
		   
		   else if(a.getSource()==r5)
		   {
			   Login l = new Login();
			   this.setVisible(false);
		   }
		   
	
	}
	
	
	
	public String getUserGroup()
	{
		
		
		try
		{
			String query = "select * from blood2 where User_Name='"+Login.u+"'";
			Connection c = DatabaseConnection.dbConnector();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			
			bGroup = rs.getString("B_Group");
			
		}
		catch(SQLException e)
		{
			System.out.println("Error from home DBC"+Login.u);
			e.printStackTrace();
		}
		
		return bGroup;
	}
}