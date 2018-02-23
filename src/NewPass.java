import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class NewPass extends JFrame implements ActionListener{
	
	
	JLabel l0 = new JLabel("User Name");
	JLabel l1 = new JLabel("New Password: ");
	JLabel l2 = new JLabel("Confirm Password: ");
	
	JTextField f0= new JTextField(); 
	JPasswordField  f1 = new JPasswordField ();
	JPasswordField  f2 = new JPasswordField ();
	
	JButton b1 = new JButton("Ok");
	
	String p,cp,u;
	
	public NewPass(String u)
	{
		setSize(700,730);
		setBackground(Color.red);
		this.setContentPane(new JLabel(new ImageIcon("Blood3.jpg")));
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setTitle("Password Change");
		
		add(l0);
		l0.setBounds(100,40,150,30);
		l1.setForeground(new Color(253,254,254));
		
		add(l1);
		l1.setBounds(100,90,150,30);
		l1.setForeground(new Color(253,254,254));
		
		add(l2);
		l2.setBounds(100,140,150,30);
		l2.setForeground(new Color(253,254,254));
		
		add(f0);
		f0.setBounds(250,40,150,28);
	    f0.setBackground(Color.lightGray);
		
		add(f1);
		f1.setBounds(250,90,150,28);
	    f1.setBackground(Color.lightGray);
		//f1.setForeground(Color.red);
		
		add(f2);
		f2.setBounds(250,140,150,28);
		f2.setBackground(Color.lightGray);
		
		add(b1);
		b1.setBounds(350, 190,85,28);
		b1.setBackground(new Color(204, 209, 209));
		
		b1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent a){
		
		
		this.u=u;
		p = new String(f1.getPassword());
		cp =new String(f2.getPassword()); 
		
		if(a.getSource()==b1)
		{
			if(!(p.equals(cp))){
				   JOptionPane.showMessageDialog(null,"Password Doesn't Match"); 
			   }
			
			else
			{
				 try
				   {
					   String query= "update blood2 set Password = "+'"'+p+'"'+" where user_name= "+'"'+u+'"';
					   Connection c = DatabaseConnection.dbConnector();
					   Statement st = c.createStatement();
					   st.executeUpdate(query);
					   
					   int count =0;
					   
						if(c!=null)
							{
								System.out.println(p + " " + cp + " ");
								JOptionPane.showMessageDialog(null,"PassWord Changed!");
								Home h = new Home(this.u);
								dispose();
								
							}
						else if(c == null)
							{
								System.out.println(p + " " + cp + " ");
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
	
		}
	}
}